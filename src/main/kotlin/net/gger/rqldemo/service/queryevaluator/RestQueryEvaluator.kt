package net.gger.rqldemo.service.queryevaluator

import net.gger.rqldemo.commons.Stack
import net.gger.rqldemo.commons.pop
import net.gger.rqldemo.commons.push
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root


data class PredicateParams<T>(
    val root: Root<T>,
    val query: CriteriaQuery<*>,
    val builder: CriteriaBuilder
)

data class CreatePredicateParams<T>(
    val operation: SearchOperation,
    val passStack: Stack<EvaluationItem>,
    val predicateParams: PredicateParams<T>
)

class RestQueryEvaluator<T>(
    private val createPredicateCallback: (CreatePredicateParams<T>) -> Predicate,
    private val predicateParams: PredicateParams<T>
) {
    fun queryExpressionToStack(expression: String): Stack<EvaluationItem> {
        // ignore symbols , ( ) and find whole words containing non-blank space:
        val expressionWordsFinder = """[^,^\\(^\\)^\"\s]+""".toRegex()
        val evaluationStack: Stack<EvaluationItem> = mutableListOf()
        for (next in expressionWordsFinder.findAll(expression)) {
            evaluationStack.push(EvaluationItem.Unevaluated(next.value))
        }
        return evaluationStack
    }

    fun evaluateStack(evaluationStack: Stack<EvaluationItem>): Predicate {
        var toEvaluate: EvaluationItem?
        val paramStack: Stack<EvaluationItem> = mutableListOf()

        toEvaluate = evaluationStack.pop()
        while (toEvaluate != null) { // While evaluation stack is not empty

            when (toEvaluate) {

                // Unevaluated items must be processed
                is EvaluationItem.Unevaluated -> {
                    val operation = SearchOperation.getOperation(toEvaluate.value)
                    if (operation == SearchOperation.UNRECOGNIZED_OPERATION) {
                        // It is parameter
                        paramStack.push(toEvaluate)
                    } else {
                        // It is operation, let's evaluate it
                        val passStack = paramStack.toMutableList()

                        // Compute and push next partial evaluation
                        evaluationStack.push(
                            EvaluationItem.PartialEvaluation(
                                createPredicateCallback(
                                    CreatePredicateParams(
                                        operation = operation,
                                        passStack = passStack,
                                        predicateParams = predicateParams
                                    )
                                )
                            )
                        )
                        // Push all partial evaluations from param stack back to evaluation
                        for (partial in paramStack.filter { it is EvaluationItem.PartialEvaluation }) {
                            evaluationStack.push(partial)
                        }
                        paramStack.clear()

                    }
                }

                // Already evaluated items are parameters for next function in line
                is EvaluationItem.PartialEvaluation -> {
                    paramStack.push(toEvaluate)
                }
            }

            toEvaluate = evaluationStack.pop() // Get next item
        }

        val lastItem: EvaluationItem? = paramStack.pop()
        return (lastItem as EvaluationItem.PartialEvaluation).predicate
    }

    fun evaluateQuery(query: String): Predicate {
        return evaluateStack(queryExpressionToStack(query))
    }
}


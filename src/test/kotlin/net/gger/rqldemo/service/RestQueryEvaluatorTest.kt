package net.gger.rqldemo.service

import net.gger.rqldemo.commons.Stack
import net.gger.rqldemo.commons.pop
import net.gger.rqldemo.entity.DataItem
import net.gger.rqldemo.service.mocks.MockCriteriaBuilder
import net.gger.rqldemo.service.mocks.MockCriteriaQuery
import net.gger.rqldemo.service.mocks.MockPredicate
import net.gger.rqldemo.service.mocks.MockRoot
import net.gger.rqldemo.service.queryevaluator.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import javax.persistence.criteria.Predicate
import net.gger.rqldemo.service.queryevaluator.EvaluationItem.*


internal class RestQueryEvaluatorTest {
    private val predicateParams = PredicateParams(root = MockRoot(), query = MockCriteriaQuery(), builder = MockCriteriaBuilder())
    private val restQueryEvaluator = RestQueryEvaluator(::createSearchPredicate, predicateParams)

    private fun createSearchPredicate(createPredicateParams: CreatePredicateParams<DataItem?>): Predicate {
        return MockPredicate(createPredicateParams.operation, createPredicateParams.passStack)
    }


    @Test
    fun evaluateSimpleExpressionTest() {
        val expression = """GREATER_THAN(id,"first-post")"""
        val result = restQueryEvaluator.evaluateStack(
            restQueryEvaluator.queryExpressionToStack(expression)
        )

        assertEquals(SearchOperation.GREATER_THAN, (result as MockPredicate).command)
        assertEquals(Unevaluated("id"), (result.parameters as Stack<EvaluationItem>).pop())
        assertEquals(Unevaluated("first-post"), result.parameters.pop())
    }


    @Test
    fun evaluateComplexExpressionBasicTest() {
        val expression = """NOT(GREATER_THAN(id,"first-post"))"""
        val result = restQueryEvaluator.evaluateStack(
            restQueryEvaluator.queryExpressionToStack(expression)
        )

        assertEquals(SearchOperation.NOT, (result as MockPredicate).command)

        val innerEvaluation = (result.parameters as Stack<EvaluationItem>).pop()
        val innerPredicate = (innerEvaluation as PartialEvaluation).predicate

        assertEquals(SearchOperation.GREATER_THAN, (innerPredicate as MockPredicate).command)
        assertEquals(Unevaluated("id"), (innerPredicate.parameters as Stack<EvaluationItem>).pop())
        assertEquals(Unevaluated("first-post"), innerPredicate.parameters.pop())
    }

    @Test
    fun evaluateDoubleComplexExpressionBasicTest() {
        val expression = """AND(EQUAL(id,"first-post"),EQUAL(views,100))"""
        val result = restQueryEvaluator.evaluateStack(
            restQueryEvaluator.queryExpressionToStack(expression)
        )

        assertEquals(SearchOperation.AND, (result as MockPredicate).command)

        val innerEvaluation1 = (result.parameters as Stack<EvaluationItem>).pop()
        val innerEvaluation2 = (result.parameters).pop()

        val innerPredicate1 = (innerEvaluation1 as PartialEvaluation).predicate
        val innerPredicate2 = (innerEvaluation2 as PartialEvaluation).predicate

        assertEquals(SearchOperation.EQUAL, (innerPredicate1 as MockPredicate).command)
        assertEquals(Unevaluated("id"), (innerPredicate1.parameters as Stack<EvaluationItem>).pop())
        assertEquals(Unevaluated("first-post"), innerPredicate1.parameters.pop())

        assertEquals(SearchOperation.EQUAL, (innerPredicate2 as MockPredicate).command)
        assertEquals(Unevaluated("views"), (innerPredicate2.parameters as Stack<EvaluationItem>).pop())
        assertEquals(Unevaluated("100"), innerPredicate2.parameters.pop())

    }

    @Test
    fun expressionToParamListParseSimpleExpression() {
        val expression = """EQUAL(id,"first-post")"""
        val result = restQueryEvaluator.queryExpressionToStack(expression)

        assertEquals("first-post", (result.pop() as Unevaluated).value)
        assertEquals("id", (result.pop() as Unevaluated).value)
        assertEquals("EQUAL", (result.pop() as Unevaluated).value)
    }


    @Test
    fun expressionToParamListParseCombinedExpression() {
        val expression = """AND( EQUAL( name , "john" ), NOT( EQUAL ( id, "second-post" ) ) )"""
        val result = restQueryEvaluator.queryExpressionToStack(expression)

        assertEquals("second-post", (result.pop() as Unevaluated).value)
        assertEquals("id", (result.pop() as Unevaluated).value)
        assertEquals("EQUAL", (result.pop() as Unevaluated).value)
        assertEquals("NOT", (result.pop() as Unevaluated).value)
        assertEquals("john", (result.pop() as Unevaluated).value)
        assertEquals("name", (result.pop() as Unevaluated).value)
        assertEquals("EQUAL", (result.pop() as Unevaluated).value)
        assertEquals("AND", (result.pop() as Unevaluated).value)
    }
}

package net.gger.rqldemo.repository


import net.gger.rqldemo.commons.pop
import net.gger.rqldemo.exception.UnsupportedOperationForSpecification
import net.gger.rqldemo.service.queryevaluator.EvaluationItem
import net.gger.rqldemo.service.queryevaluator.SearchCriteria
import net.gger.rqldemo.service.queryevaluator.SearchOperation
import org.springframework.data.jpa.domain.Specification
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

class QuerySpecification<T>(
    private val criteria: SearchCriteria
) : Specification<T?> {

    override fun toPredicate(root: Root<T?>, query: CriteriaQuery<*>, builder: CriteriaBuilder): Predicate {

        return when(criteria.operation) {
            SearchOperation.GREATER_THAN -> {
                val name = (criteria.params.pop() as EvaluationItem.Unevaluated).value
                val value = (criteria.params.pop() as EvaluationItem.Unevaluated).value

                builder.greaterThan(root.get(name), value)
            }

            SearchOperation.LESS_THAN -> {
                val name = (criteria.params.pop() as EvaluationItem.Unevaluated).value
                val value = (criteria.params.pop() as EvaluationItem.Unevaluated).value

                builder.lessThan(root.get(name), value)
            }

            SearchOperation.EQUAL -> {
                val name = (criteria.params.pop() as EvaluationItem.Unevaluated).value
                val value = (criteria.params.pop() as EvaluationItem.Unevaluated).value

                builder.equal(root.get<String>(name), value)
            }

            SearchOperation.AND -> {
                val secondPredicate = (criteria.params.pop() as EvaluationItem.PartialEvaluation).predicate
                val firstPredicate = (criteria.params.pop() as EvaluationItem.PartialEvaluation).predicate

                builder.and(firstPredicate, secondPredicate)
            }

            SearchOperation.NOT -> {
                val predicate = (criteria.params.pop() as EvaluationItem.PartialEvaluation).predicate

                builder.not(predicate)
            }

            SearchOperation.OR -> {
                val secondPredicate = (criteria.params.pop() as EvaluationItem.PartialEvaluation).predicate
                val firstPredicate = (criteria.params.pop() as EvaluationItem.PartialEvaluation).predicate

                builder.or(firstPredicate, secondPredicate)
            }

            else -> throw UnsupportedOperationForSpecification("${criteria.operation} is not supported in QuerySpecification")
        }
    }
}
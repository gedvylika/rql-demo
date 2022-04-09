package net.gger.rqldemo.repository

import net.gger.rqldemo.entity.DataItem
import net.gger.rqldemo.service.queryevaluator.*
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root


@Repository
class DataItemSearchDAO(
    private val em: EntityManager
){

    fun findDataItemsByQuery(queryParam: String): List<DataItem>? {
        val builder = em.criteriaBuilder
        val query: CriteriaQuery<DataItem> = builder.createQuery(DataItem::class.java)
        val variableRoot: Root<DataItem?> = query.from(DataItem::class.java)

        val predicateParams = PredicateParams(root = variableRoot, query = query, builder = builder)
        val queryEvaluator = RestQueryEvaluator(::createSearchPredicate, predicateParams)

        query.select(variableRoot).where(queryEvaluator.evaluateQuery(queryParam))

        return em.createQuery(query).resultList
    }

    private fun createSearchPredicate(params: CreatePredicateParams<DataItem?>): Predicate {
        return QuerySpecification<DataItem>(
            SearchCriteria(params.operation, params.passStack)
        ).toPredicate(
            root = params.predicateParams.root,
            query = params.predicateParams.query,
            builder = params.predicateParams.builder)
    }
}
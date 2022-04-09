package net.gger.rqldemo.service.queryevaluator

import javax.persistence.criteria.Predicate

sealed class EvaluationItem {
    data class Unevaluated(
        val value: String
    ) : EvaluationItem()

    data class PartialEvaluation(
        val predicate: Predicate
    ) : EvaluationItem()
}
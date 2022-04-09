package net.gger.rqldemo.service.queryevaluator

import net.gger.rqldemo.commons.Stack

data class SearchCriteria (
    val operation: SearchOperation,
    val params: Stack<EvaluationItem>
)
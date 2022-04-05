package net.gger.rqldemo.service.contract

import net.gger.rqldemo.entity.DemoDataItem

sealed class DemoDataItemServiceQueryResponse {
    data class Success(
        val result: List<DemoDataItem>
    ) : DemoDataItemServiceQueryResponse()

    data class Failure(
        val error: Exception
    ) : DemoDataItemServiceQueryResponse()
}
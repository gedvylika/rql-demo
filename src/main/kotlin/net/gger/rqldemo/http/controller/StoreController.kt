package net.gger.rqldemo.http.controller

import net.gger.rqldemo.entity.DemoDataItem
import net.gger.rqldemo.exception.CanNotQueryDataItemsException
import net.gger.rqldemo.http.payload.DemoDataItemPayload
import net.gger.rqldemo.http.resource.QueryDemoDataItemResource
import net.gger.rqldemo.service.DemoDataItemService
import net.gger.rqldemo.service.contract.DemoDataItemServiceQueryResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/store")
class StoreController(
    val demoDataItemService: DemoDataItemService
) {

    @GetMapping
    fun queryDemoDataItem(@RequestParam query: String): QueryDemoDataItemResource {

        return when (val response = demoDataItemService.query()) {
            is DemoDataItemServiceQueryResponse.Success -> QueryDemoDataItemResource.fromDataItemList(response.result)
            is DemoDataItemServiceQueryResponse.Failure -> throw CanNotQueryDataItemsException(response.error.message)
         }
    }

    @PostMapping
    fun insertDemoDataItem(@RequestBody payloadItem: DemoDataItemPayload) {
        demoDataItemService.insert(
            DemoDataItem(
                id = payloadItem.id,
                title = payloadItem.title,
                content = payloadItem.content,
                views = payloadItem.views,
                timestamp = payloadItem.timestamp
            )
        )
    }
}
package net.gger.rqldemo.http.controller

import net.gger.rqldemo.entity.DemoDataItem
import net.gger.rqldemo.http.payload.DemoDataItemPayload
import net.gger.rqldemo.http.resource.QueryDemoDataItemResource
import net.gger.rqldemo.service.DemoDataItemService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/store")
class StoreController(
    val demoDataItemService: DemoDataItemService
) {

    @GetMapping
    @ResponseBody
    fun queryDemoDataItem(@RequestParam query: String?): QueryDemoDataItemResource {
        return QueryDemoDataItemResource.fromDataItemList(demoDataItemService.query())
    }

    @PostMapping
    fun insertDemoDataItem(@RequestBody payloadItem: DemoDataItemPayload): ResponseEntity<String> {
        demoDataItemService.insert(
            DemoDataItem(
                id = payloadItem.id,
                title = payloadItem.title,
                content = payloadItem.content,
                views = payloadItem.views,
                timestamp = payloadItem.timestamp
            )
        )
        return ResponseEntity.ok().build()
    }
}
package net.gger.rqldemo.http.controller

import net.gger.rqldemo.entity.DataItem
import net.gger.rqldemo.http.payload.DataItemPayload
import net.gger.rqldemo.http.resource.QueryDataItemResource
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
    fun queryDataItem(@RequestParam query: String): QueryDataItemResource {
        return QueryDataItemResource.fromDataItemList(
            demoDataItemService.query(query)
        )
    }

    @PostMapping
    fun insertDataItem(@RequestBody payloadItem: DataItemPayload): ResponseEntity<String> {
        demoDataItemService.insert(
            DataItem(
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
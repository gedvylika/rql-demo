package net.gger.rqldemo.http.resource

import net.gger.rqldemo.entity.DemoDataItem

data class ResponseDemoDataItem(
    val id: String,
    val title: String,
    val content: String,
    val views: Int,
    val timestamp: Long

) {
    companion object {
        // Response Item factory
        fun fromDataItem(item: DemoDataItem): ResponseDemoDataItem {
            return ResponseDemoDataItem(
                id = item.id,
                title = item.title,
                content = item.content,
                views = item.views,
                timestamp = item.timestamp
            )
        }
    }

}

data class QueryDemoDataItemResource(
    val items: List<ResponseDemoDataItem>

) {
    companion object {
        // Query Resource factory
        fun fromDataItemList(itemList: List<DemoDataItem>): QueryDemoDataItemResource {
            return QueryDemoDataItemResource(
                items = itemList.map { ResponseDemoDataItem.fromDataItem(it) }
            )
        }
    }
}


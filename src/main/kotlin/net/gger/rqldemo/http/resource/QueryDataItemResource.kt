package net.gger.rqldemo.http.resource

import net.gger.rqldemo.entity.DataItem

data class ResponseDataItem(
    val id: String,
    val title: String,
    val content: String,
    val views: Int,
    val timestamp: Long

) {
    companion object {
        // Response Item factory
        fun fromDataItem(item: DataItem): ResponseDataItem {
            return ResponseDataItem(
                id = item.id,
                title = item.title,
                content = item.content,
                views = item.views,
                timestamp = item.timestamp
            )
        }
    }

}

data class QueryDataItemResource(
    val items: List<ResponseDataItem>

) {
    companion object {
        // Query Resource factory
        fun fromDataItemList(itemList: List<DataItem>?): QueryDataItemResource {
            return QueryDataItemResource(
                items = itemList?.map { ResponseDataItem.fromDataItem(it) } ?: listOf()
            )
        }
    }
}


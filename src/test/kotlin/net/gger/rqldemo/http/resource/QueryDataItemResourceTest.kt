package net.gger.rqldemo.http.resource

import net.gger.rqldemo.entity.DataItem
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.UUID

internal class QueryDataItemResourceTest {
    val dataItem = DataItem(
        id = UUID.randomUUID().toString(),
        title = "Test data item title",
        content = "Content needs to store some valuable text",
        views = 1000,
        timestamp = System.currentTimeMillis()
    )

    @Test
    fun ResponseDemoDataItemFactoryTest() {
        val responseItem: ResponseDataItem = ResponseDataItem.fromDataItem(dataItem)
        itemAssertions(responseItem)
    }


    @Test
    fun QueryDemoDataItemResourceFactoryTest() {
        val resource =  QueryDataItemResource.fromDataItemList(listOf(dataItem))
        assertEquals(1, resource.items.size)
        itemAssertions(resource.items[0])
    }

    private fun itemAssertions(responseItem: ResponseDataItem) {
        assertEquals(dataItem.id, responseItem.id)
        assertEquals(dataItem.content, responseItem.content)
        assertEquals(dataItem.title, responseItem.title)
        assertEquals(dataItem.views, responseItem.views)
        assertEquals(dataItem.timestamp, responseItem.timestamp)
    }
}
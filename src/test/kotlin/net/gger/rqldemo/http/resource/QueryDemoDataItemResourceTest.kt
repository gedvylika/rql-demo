package net.gger.rqldemo.http.resource

import net.gger.rqldemo.entity.DemoDataItem
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.Date
import java.util.UUID

internal class QueryDemoDataItemResourceTest {
    val demoDataItem = DemoDataItem(
        id = UUID.randomUUID().toString(),
        title = "Test data item title",
        content = "Content needs to store some valuable text",
        views = 1000,
        timestamp = System.currentTimeMillis()
    )

    @Test
    fun ResponseDemoDataItemFactoryTest() {
        val responseItem: ResponseDemoDataItem = ResponseDemoDataItem.fromDataItem(demoDataItem)
        itemAssertions(responseItem)
    }


    @Test
    fun QueryDemoDataItemResourceFactoryTest() {
        val resource =  QueryDemoDataItemResource.fromDataItemList(listOf(demoDataItem))
        assertEquals(1, resource.items.size)
        itemAssertions(resource.items[0])
    }

    private fun itemAssertions(responseItem: ResponseDemoDataItem) {
        assertEquals(demoDataItem.id, responseItem.id)
        assertEquals(demoDataItem.content, responseItem.content)
        assertEquals(demoDataItem.title, responseItem.title)
        assertEquals(demoDataItem.views, responseItem.views)
        assertEquals(demoDataItem.timestamp, responseItem.timestamp)
    }
}
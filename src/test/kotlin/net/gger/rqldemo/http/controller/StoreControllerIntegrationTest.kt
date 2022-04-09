package net.gger.rqldemo.http.controller

import com.fasterxml.jackson.databind.ObjectMapper
import net.gger.rqldemo.entity.DataItem
import net.gger.rqldemo.repository.DataItemRepository
import net.gger.rqldemo.repository.DataItemSearchDAO
import net.gger.rqldemo.service.DemoDataItemService
import org.junit.jupiter.api.Test
import org.hamcrest.Matchers.containsString

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType.APPLICATION_JSON

@WebMvcTest(StoreController::class, DemoDataItemService::class, DataItemRepository::class, DataItemSearchDAO::class, DataItemRepository::class)
internal class StoreControllerIntegrationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var demoDataItemService: DemoDataItemService

    @Autowired lateinit var dataItemRepository: DataItemRepository

    private val testDataItem = DataItem(
        id = "1",
        title = "title",
        content = "content",
        views = 0,
        timestamp = 0L
    )

    val objectMapper = ObjectMapper()
    val testDataItemJson = objectMapper.writeValueAsString(testDataItem)

    @Test
    fun queryDemoDataItem() {
        Mockito.`when`(demoDataItemService.query("test")).thenReturn(listOf(testDataItem));

        this.mockMvc
            .perform(get("/store").param("query", "test"))
            .andExpect(status().isOk)
            .andExpect(content().string(containsString(testDataItemJson)));
    }

    @Test
    fun insertDemoDataItem() {
        this.mockMvc
            .perform(
                post("/store").contentType(APPLICATION_JSON).content(testDataItemJson)
            )
            .andExpect(status().isOk)
    }
}
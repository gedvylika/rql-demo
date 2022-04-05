package net.gger.rqldemo.http.controller

import com.fasterxml.jackson.databind.ObjectMapper
import net.gger.rqldemo.entity.DemoDataItem
import net.gger.rqldemo.service.DemoDataItemService
import org.junit.jupiter.api.Test
import org.hamcrest.Matchers.containsString

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType.APPLICATION_JSON

@WebMvcTest(StoreController::class)
internal class StoreControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var demoDataItemService: DemoDataItemService


    private val testDataItem = DemoDataItem(
        id = "1",
        title = "title",
        content = "content",
        views = 0,
        timestamp = 0L
    )

    @Test
    fun queryDemoDataItem() {
        Mockito.`when`(demoDataItemService.query()).thenReturn(listOf(testDataItem));

        this.mockMvc
            .perform(get("/store"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("""{"items":[{"id":"1","title":"title","content":"content","views":0,"timestamp":0}]}""")));
    }

    @Test
    fun insertDemoDataItem() {
        val objectMapper = ObjectMapper()
        val requestJson = objectMapper.writeValueAsString(testDataItem)
        this.mockMvc
            .perform(
                post("/store").contentType(APPLICATION_JSON).content(requestJson)
            )
            .andDo(print())
            .andExpect(status().isOk())
    }
}
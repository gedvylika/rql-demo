package net.gger.rqldemo.http.controller

import junit.framework.TestCase.assertEquals
import net.gger.rqldemo.config.AppTestConfiguration
import net.gger.rqldemo.http.payload.DataItemPayload
import net.gger.rqldemo.repository.DataItemRepository
import org.junit.Assert.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Import
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
@Import(AppTestConfiguration::class)
internal class StoreControllerInsertIntegrationTest {
    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Autowired
    private lateinit var dataItemRepository: DataItemRepository

    private val testDataItem1 = DataItemPayload(
        id = "one",
        title = "title",
        content = "best item in the world",
        views =  456,
        timestamp = 1
    )

    private val testDataItem2 = DataItemPayload(
        id = "two",
        title = "second best title",
        content = "not the best item in the world",
        views =  999,
        timestamp = 2
    )

    @BeforeEach
    fun setUp() {
        dataItemRepository.deleteAll()
    }

    @Test
    fun insertDemoDataItem() {
        val result = restTemplate.postForEntity(
            "/store",
            testDataItem1,
            DataItemPayload::class.java
        )

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)

        val itemPersisted = dataItemRepository.getById("one")

        assertNotNull(itemPersisted)
        assertEquals(testDataItem1.title, itemPersisted.title)
        assertEquals(testDataItem1.content, itemPersisted.content)
        assertEquals(testDataItem1.views, itemPersisted.views)
        assertEquals(testDataItem1.timestamp, itemPersisted.timestamp)
    }

    @Test
    fun `second item with same id must owerwrite`() {
        val result = restTemplate.postForEntity(
            "/store",
            testDataItem1,
            DataItemPayload::class.java
        )

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)


        val result2 = restTemplate.postForEntity(
            "/store",
            testDataItem1.copy(
                title = "overwritten ${testDataItem1.title}",
                content = "overwritten ${testDataItem1.content}",
                timestamp = testDataItem1.timestamp + 100,
                views = testDataItem1.views + 100
            ),
            DataItemPayload::class.java
        )

        assertNotNull(result2)
        assertEquals(HttpStatus.OK, result2?.statusCode)

        val itemPersisted = dataItemRepository.getById("one")

        assertNotNull(itemPersisted)
        assertEquals("overwritten ${testDataItem1.title}", itemPersisted.title)
        assertEquals("overwritten ${testDataItem1.content}", itemPersisted.content)
        assertEquals(testDataItem1.views + 100, itemPersisted.views)
        assertEquals(testDataItem1.timestamp + 100, itemPersisted.timestamp)


        assertEquals(1, dataItemRepository.count())
    }
}
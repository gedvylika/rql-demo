package net.gger.rqldemo.http.controller

import junit.framework.TestCase.assertEquals
import net.gger.rqldemo.config.AppTestConfiguration
import net.gger.rqldemo.entity.DataItem
import net.gger.rqldemo.http.resource.QueryDataItemResource
import net.gger.rqldemo.http.resource.ResponseDataItem
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
internal class StoreControllerQueryIntegrationTest {
    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Autowired
    private lateinit var dataItemRepository: DataItemRepository

    private val testDataItem1 = DataItem(
        id = "first-post",
        title = "title",
        content = "best item in the world",
        views =  100,
        timestamp = 1
    )

    private val testDataItem2 = DataItem(
        id = "second-post",
        title = "second best title",
        content = "not the best item in the world",
        views =  50,
        timestamp = 2
    )

    private val testDataItem3 = DataItem(
        id = "third-post",
        title = "third best title",
        content = "well...",
        views =  500,
        timestamp = 3
    )

    @BeforeEach
    fun setUp() {
        dataItemRepository.deleteAll()
        dataItemRepository.saveAll(listOf(testDataItem1, testDataItem2, testDataItem3))
    }

    @Test
    fun `test querying equal by id`() {
        val query = """EQUAL(id,"first-post")"""
        val result = restTemplate.getForEntity("/store?query=$query", QueryDataItemResource::class.java)

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)

        assertNotNull(result.body?.items)
        assertEquals(1, result.body?.items?.size)

        assertEquals(ResponseDataItem.fromDataItem(testDataItem1), result.body!!.items[0])
    }

    @Test
    fun `test querying equal by views`() {
        val query = """EQUAL(views,100)"""
        val result = restTemplate.getForEntity("/store?query=$query", QueryDataItemResource::class.java)

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)

        assertNotNull(result.body?.items)
        assertEquals(1, result.body?.items?.size)

        assertEquals(ResponseDataItem.fromDataItem(testDataItem1), result.body!!.items[0])
    }

    @Test
    fun `test querying equal by id and views`() {
        val query = """AND(EQUAL(id,"first-post"),EQUAL(views,100))"""
        val result = restTemplate.getForEntity("/store?query=$query", QueryDataItemResource::class.java)

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)

        assertNotNull(result.body?.items)
        assertEquals(1, result.body?.items?.size)

        assertEquals(ResponseDataItem.fromDataItem(testDataItem1), result.body!!.items[0])
    }

    @Test
    fun `test querying equal by id and views no results`() {
        val query = """AND(EQUAL(id,"first-post"),EQUAL(views,9999))"""
        val result = restTemplate.getForEntity("/store?query=$query", QueryDataItemResource::class.java)

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)

        assertNotNull(result.body?.items)
        assertEquals(0, result.body?.items?.size)
    }

    @Test
    fun `test querying or equal ids `() {
        val query = """OR(EQUAL(id,"first-post"),EQUAL(id,"second-post"))"""
        val result = restTemplate.getForEntity("/store?query=$query", QueryDataItemResource::class.java)

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)

        assertNotNull(result.body?.items)
        assertEquals(2, result.body?.items?.size)

        assertEquals(ResponseDataItem.fromDataItem(testDataItem1), result.body!!.items[0])
        assertEquals(ResponseDataItem.fromDataItem(testDataItem2), result.body!!.items[1])
    }

    @Test
    fun `test querying not equal first post`() {
        val query = """NOT(EQUAL(id,"first-post"))"""
        val result = restTemplate.getForEntity("/store?query=$query", QueryDataItemResource::class.java)

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)

        assertNotNull(result.body?.items)
        assertEquals(2, result.body?.items?.size)

        assertEquals(ResponseDataItem.fromDataItem(testDataItem2), result.body!!.items[0])
        assertEquals(ResponseDataItem.fromDataItem(testDataItem3), result.body!!.items[1])
    }


    @Test
    fun `test querying greater than views`() {
        val query = """GREATER_THAN(views,100)"""
        val result = restTemplate.getForEntity("/store?query=$query", QueryDataItemResource::class.java)

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)

        assertNotNull(result.body?.items)
        assertEquals(1, result.body?.items?.size)

        assertEquals(ResponseDataItem.fromDataItem(testDataItem3), result.body!!.items[0])
    }

    @Test
    fun `test querying less than views`() {
        val query = """LESS_THAN(views,100)"""
        val result = restTemplate.getForEntity("/store?query=$query", QueryDataItemResource::class.java)

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)

        assertNotNull(result.body?.items)
        assertEquals(1, result.body?.items?.size)

        assertEquals(ResponseDataItem.fromDataItem(testDataItem2), result.body!!.items[0])
    }

    @Test
    fun `test querying greater than views nonexistent`() {
        val query = """GREATER_THAN(views,9999)"""
        val result = restTemplate.getForEntity("/store?query=$query", QueryDataItemResource::class.java)

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)

        assertNotNull(result.body?.items)
        assertEquals(0, result.body?.items?.size)
    }

    @Test
    fun `test querying less than views nonexistent`() {
        val query = """LESS_THAN(views,2)"""
        val result = restTemplate.getForEntity("/store?query=$query", QueryDataItemResource::class.java)

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)

        assertNotNull(result.body?.items)
        assertEquals(0, result.body?.items?.size)
    }

}
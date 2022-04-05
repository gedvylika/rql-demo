package net.gger.rqldemo.http.payload

data class DemoDataItemPayload(
    val id: String,
    val title: String,
    val content: String,
    val views: Int,
    val timestamp: Long
)

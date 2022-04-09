package net.gger.rqldemo.http.payload

data class DataItemPayload(
    val id: String,
    val title: String,
    val content: String,
    val views: Int,
    val timestamp: Long
)

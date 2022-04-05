package net.gger.rqldemo.entity

import javax.persistence.*

@Entity
@Table(name = "demo_data_item")
data class DemoDataItem(
    @Id
    @Column(name = "id", nullable = false)
    val id: String,

    @Column(name = "title")
    val title: String,

    @Column(name = "content")
    val content: String,

    @Column(name = "views")
    val views: Int,

    @Column(name = "timestamp")
    val timestamp: Long
)
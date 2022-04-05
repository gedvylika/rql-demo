package net.gger.rqldemo.service

import net.gger.rqldemo.entity.DemoDataItem
import net.gger.rqldemo.repository.DemoDataItemRepository
import org.springframework.stereotype.Service

@Service
class DemoDataItemService(
    private val demoDataItemRepository: DemoDataItemRepository
) {
    fun insert(demoDataItem: DemoDataItem) {
        demoDataItemRepository.save(demoDataItem)
    }

    fun query(): List<DemoDataItem> {
        return listOf(
            DemoDataItem(
                id = "1",
                title = "",
                content = "",
                views = 0,
                timestamp = 0L
            )
        )
    }
}
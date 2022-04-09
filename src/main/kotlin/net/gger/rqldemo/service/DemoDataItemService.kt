package net.gger.rqldemo.service

import net.gger.rqldemo.entity.DataItem
import net.gger.rqldemo.repository.DataItemRepository
import net.gger.rqldemo.repository.DataItemSearchDAO
import org.springframework.stereotype.Service

@Service
class DemoDataItemService(
    private val dataItemRepository: DataItemRepository,
    private val dateItemSearchDAO: DataItemSearchDAO
) {
    fun insert(dataItem: DataItem) {
        dataItemRepository.save(dataItem)
    }

    fun query(query: String): List<DataItem>? {
        return dateItemSearchDAO.findDataItemsByQuery(query)
    }
}
package net.gger.rqldemo.repository

import net.gger.rqldemo.entity.DataItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface DataItemRepository : JpaRepository<DataItem, String>, JpaSpecificationExecutor<DataItem>
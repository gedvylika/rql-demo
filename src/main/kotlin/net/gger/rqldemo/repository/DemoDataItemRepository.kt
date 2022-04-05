package net.gger.rqldemo.repository

import net.gger.rqldemo.entity.DemoDataItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface DemoDataItemRepository : JpaRepository<DemoDataItem, String>, JpaSpecificationExecutor<DemoDataItem>
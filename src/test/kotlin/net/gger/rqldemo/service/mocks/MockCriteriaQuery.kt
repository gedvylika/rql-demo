package net.gger.rqldemo.service.mocks

import net.gger.rqldemo.entity.DataItem
import javax.persistence.criteria.*
import javax.persistence.metamodel.EntityType

class MockCriteriaQuery: CriteriaQuery<DataItem> {
    override fun <U : Any?> subquery(type: Class<U>?): Subquery<U> {
        TODO("Not yet implemented")
    }

    override fun getRestriction(): Predicate {
        TODO("Not yet implemented")
    }

    override fun <X : Any?> from(entityClass: Class<X>?): Root<X> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?> from(entity: EntityType<X>?): Root<X> {
        TODO("Not yet implemented")
    }

    override fun where(restriction: Expression<Boolean>?): CriteriaQuery<DataItem> {
        TODO("Not yet implemented")
    }

    override fun where(vararg restrictions: Predicate?): CriteriaQuery<DataItem> {
        TODO("Not yet implemented")
    }

    override fun groupBy(vararg grouping: Expression<*>?): CriteriaQuery<DataItem> {
        TODO("Not yet implemented")
    }

    override fun groupBy(grouping: MutableList<Expression<*>>?): CriteriaQuery<DataItem> {
        TODO("Not yet implemented")
    }

    override fun having(restriction: Expression<Boolean>?): CriteriaQuery<DataItem> {
        TODO("Not yet implemented")
    }

    override fun having(vararg restrictions: Predicate?): CriteriaQuery<DataItem> {
        TODO("Not yet implemented")
    }

    override fun distinct(distinct: Boolean): CriteriaQuery<DataItem> {
        TODO("Not yet implemented")
    }

    override fun getRoots(): MutableSet<Root<*>> {
        TODO("Not yet implemented")
    }

    override fun getSelection(): Selection<DataItem> {
        TODO("Not yet implemented")
    }

    override fun getGroupList(): MutableList<Expression<*>> {
        TODO("Not yet implemented")
    }

    override fun getGroupRestriction(): Predicate {
        TODO("Not yet implemented")
    }

    override fun isDistinct(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getResultType(): Class<DataItem> {
        TODO("Not yet implemented")
    }

    override fun select(selection: Selection<out DataItem>?): CriteriaQuery<DataItem> {
        TODO("Not yet implemented")
    }

    override fun multiselect(vararg selections: Selection<*>?): CriteriaQuery<DataItem> {
        TODO("Not yet implemented")
    }

    override fun multiselect(selectionList: MutableList<Selection<*>>?): CriteriaQuery<DataItem> {
        TODO("Not yet implemented")
    }

    override fun orderBy(vararg o: Order?): CriteriaQuery<DataItem> {
        TODO("Not yet implemented")
    }

    override fun orderBy(o: MutableList<Order>?): CriteriaQuery<DataItem> {
        TODO("Not yet implemented")
    }

    override fun getOrderList(): MutableList<Order> {
        TODO("Not yet implemented")
    }

    override fun getParameters(): MutableSet<ParameterExpression<*>> {
        TODO("Not yet implemented")
    }
}
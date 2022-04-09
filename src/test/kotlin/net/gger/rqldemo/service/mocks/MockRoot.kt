package net.gger.rqldemo.service.mocks

import net.gger.rqldemo.entity.DataItem
import javax.persistence.criteria.*
import javax.persistence.metamodel.*

class MockRoot:  Root<DataItem?> {
    override fun getJavaType(): Class<out DataItem?> {
        TODO("Not yet implemented")
    }

    override fun getAlias(): String {
        TODO("Not yet implemented")
    }

    override fun alias(name: String?): Selection<DataItem?> {
        TODO("Not yet implemented")
    }

    override fun isCompoundSelection(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getCompoundSelectionItems(): MutableList<Selection<*>> {
        TODO("Not yet implemented")
    }

    override fun isNull(): Predicate {
        TODO("Not yet implemented")
    }

    override fun isNotNull(): Predicate {
        TODO("Not yet implemented")
    }

    override fun `in`(vararg values: Any?): Predicate {
        TODO("Not yet implemented")
    }

    override fun `in`(vararg values: Expression<*>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun `in`(values: MutableCollection<*>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun `in`(values: Expression<MutableCollection<*>>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun <X : Any?> `as`(type: Class<X>?): Expression<X> {
        TODO("Not yet implemented")
    }

    override fun getModel(): EntityType<DataItem?> {
        TODO("Not yet implemented")
    }

    override fun getParentPath(): Path<*> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> get(attribute: SingularAttribute<in DataItem?, Y>?): Path<Y> {
        TODO("Not yet implemented")
    }

    override fun <E : Any?, C : MutableCollection<E>?> get(collection: PluralAttribute<DataItem?, C, E>?): Expression<C> {
        TODO("Not yet implemented")
    }

    override fun <K : Any?, V : Any?, M : MutableMap<K, V>?> get(map: MapAttribute<DataItem?, K, V>?): Expression<M> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> get(attributeName: String?): Path<Y> {
        TODO("Not yet implemented")
    }

    override fun type(): Expression<Class<out DataItem?>> {
        TODO("Not yet implemented")
    }

    override fun getFetches(): MutableSet<Fetch<DataItem?, *>> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> fetch(attribute: SingularAttribute<in DataItem?, Y>?): Fetch<DataItem?, Y> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> fetch(attribute: SingularAttribute<in DataItem?, Y>?, jt: JoinType?): Fetch<DataItem?, Y> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> fetch(attribute: PluralAttribute<in DataItem?, *, Y>?): Fetch<DataItem?, Y> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> fetch(attribute: PluralAttribute<in DataItem?, *, Y>?, jt: JoinType?): Fetch<DataItem?, Y> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, Y : Any?> fetch(attributeName: String?): Fetch<X, Y> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, Y : Any?> fetch(attributeName: String?, jt: JoinType?): Fetch<X, Y> {
        TODO("Not yet implemented")
    }

    override fun getJoins(): MutableSet<Join<DataItem?, *>> {
        TODO("Not yet implemented")
    }

    override fun isCorrelated(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getCorrelationParent(): From<DataItem?, DataItem?> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> join(attribute: SingularAttribute<in DataItem?, Y>?): Join<DataItem?, Y> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> join(attribute: SingularAttribute<in DataItem?, Y>?, jt: JoinType?): Join<DataItem?, Y> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> join(collection: CollectionAttribute<in DataItem?, Y>?): CollectionJoin<DataItem?, Y> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> join(set: SetAttribute<in DataItem?, Y>?): SetJoin<DataItem?, Y> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> join(list: ListAttribute<in DataItem?, Y>?): ListJoin<DataItem?, Y> {
        TODO("Not yet implemented")
    }

    override fun <K : Any?, V : Any?> join(map: MapAttribute<in DataItem?, K, V>?): MapJoin<DataItem?, K, V> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> join(
        collection: CollectionAttribute<in DataItem?, Y>?,
        jt: JoinType?
    ): CollectionJoin<DataItem?, Y> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> join(set: SetAttribute<in DataItem?, Y>?, jt: JoinType?): SetJoin<DataItem?, Y> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> join(list: ListAttribute<in DataItem?, Y>?, jt: JoinType?): ListJoin<DataItem?, Y> {
        TODO("Not yet implemented")
    }

    override fun <K : Any?, V : Any?> join(
        map: MapAttribute<in DataItem?, K, V>?,
        jt: JoinType?
    ): MapJoin<DataItem?, K, V> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, Y : Any?> join(attributeName: String?): Join<X, Y> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, Y : Any?> join(attributeName: String?, jt: JoinType?): Join<X, Y> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, Y : Any?> joinCollection(attributeName: String?): CollectionJoin<X, Y> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, Y : Any?> joinCollection(attributeName: String?, jt: JoinType?): CollectionJoin<X, Y> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, Y : Any?> joinSet(attributeName: String?): SetJoin<X, Y> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, Y : Any?> joinSet(attributeName: String?, jt: JoinType?): SetJoin<X, Y> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, Y : Any?> joinList(attributeName: String?): ListJoin<X, Y> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, Y : Any?> joinList(attributeName: String?, jt: JoinType?): ListJoin<X, Y> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, K : Any?, V : Any?> joinMap(attributeName: String?): MapJoin<X, K, V> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, K : Any?, V : Any?> joinMap(attributeName: String?, jt: JoinType?): MapJoin<X, K, V> {
        TODO("Not yet implemented")
    }
}
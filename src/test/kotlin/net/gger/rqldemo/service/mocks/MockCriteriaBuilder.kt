package net.gger.rqldemo.service.mocks

import java.math.BigDecimal
import java.math.BigInteger
import java.sql.Date
import java.sql.Time
import java.sql.Timestamp
import javax.persistence.Tuple
import javax.persistence.criteria.*

class MockCriteriaBuilder: CriteriaBuilder {
    override fun toString(character: Expression<Char>?): Expression<String> {
        TODO("Not yet implemented")
    }

    override fun createQuery(): CriteriaQuery<Any> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> createQuery(resultClass: Class<T>?): CriteriaQuery<T> {
        TODO("Not yet implemented")
    }

    override fun createTupleQuery(): CriteriaQuery<Tuple> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> createCriteriaUpdate(targetEntity: Class<T>?): CriteriaUpdate<T> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> createCriteriaDelete(targetEntity: Class<T>?): CriteriaDelete<T> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> construct(resultClass: Class<Y>?, vararg selections: Selection<*>?): CompoundSelection<Y> {
        TODO("Not yet implemented")
    }

    override fun tuple(vararg selections: Selection<*>?): CompoundSelection<Tuple> {
        TODO("Not yet implemented")
    }

    override fun array(vararg selections: Selection<*>?): CompoundSelection<Array<Any>> {
        TODO("Not yet implemented")
    }

    override fun asc(x: Expression<*>?): Order {
        TODO("Not yet implemented")
    }

    override fun desc(x: Expression<*>?): Order {
        TODO("Not yet implemented")
    }

    override fun <N : Number?> avg(x: Expression<N>?): Expression<Double> {
        TODO("Not yet implemented")
    }

    override fun <N : Number?> sum(x: Expression<N>?): Expression<N> {
        TODO("Not yet implemented")
    }

    override fun <N : Number?> sum(x: Expression<out N>?, y: Expression<out N>?): Expression<N> {
        TODO("Not yet implemented")
    }

    override fun <N : Number?> sum(x: Expression<out N>?, y: N): Expression<N> {
        TODO("Not yet implemented")
    }

    override fun <N : Number?> sum(x: N, y: Expression<out N>?): Expression<N> {
        TODO("Not yet implemented")
    }

    override fun sumAsLong(x: Expression<Int>?): Expression<Long> {
        TODO("Not yet implemented")
    }

    override fun sumAsDouble(x: Expression<Float>?): Expression<Double> {
        TODO("Not yet implemented")
    }

    override fun <N : Number?> max(x: Expression<N>?): Expression<N> {
        TODO("Not yet implemented")
    }

    override fun <N : Number?> min(x: Expression<N>?): Expression<N> {
        TODO("Not yet implemented")
    }

    override fun <X : Comparable<X>?> greatest(x: Expression<X>?): Expression<X> {
        TODO("Not yet implemented")
    }

    override fun <X : Comparable<X>?> least(x: Expression<X>?): Expression<X> {
        TODO("Not yet implemented")
    }

    override fun count(x: Expression<*>?): Expression<Long> {
        TODO("Not yet implemented")
    }

    override fun countDistinct(x: Expression<*>?): Expression<Long> {
        TODO("Not yet implemented")
    }

    override fun exists(subquery: Subquery<*>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> all(subquery: Subquery<Y>?): Expression<Y> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> some(subquery: Subquery<Y>?): Expression<Y> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> any(subquery: Subquery<Y>?): Expression<Y> {
        TODO("Not yet implemented")
    }

    override fun and(x: Expression<Boolean>?, y: Expression<Boolean>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun and(vararg restrictions: Predicate?): Predicate {
        TODO("Not yet implemented")
    }

    override fun or(x: Expression<Boolean>?, y: Expression<Boolean>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun or(vararg restrictions: Predicate?): Predicate {
        TODO("Not yet implemented")
    }

    override fun not(restriction: Expression<Boolean>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun conjunction(): Predicate {
        TODO("Not yet implemented")
    }

    override fun disjunction(): Predicate {
        TODO("Not yet implemented")
    }

    override fun isTrue(x: Expression<Boolean>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun isFalse(x: Expression<Boolean>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun isNull(x: Expression<*>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun isNotNull(x: Expression<*>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun equal(x: Expression<*>?, y: Expression<*>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun equal(x: Expression<*>?, y: Any?): Predicate {
        TODO("Not yet implemented")
    }

    override fun notEqual(x: Expression<*>?, y: Expression<*>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun notEqual(x: Expression<*>?, y: Any?): Predicate {
        TODO("Not yet implemented")
    }

    override fun <Y : Comparable<Y>?> greaterThan(x: Expression<out Y>?, y: Expression<out Y>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun <Y : Comparable<Y>?> greaterThan(x: Expression<out Y>?, y: Y): Predicate {
        TODO("Not yet implemented")
    }

    override fun <Y : Comparable<Y>?> greaterThanOrEqualTo(x: Expression<out Y>?, y: Expression<out Y>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun <Y : Comparable<Y>?> greaterThanOrEqualTo(x: Expression<out Y>?, y: Y): Predicate {
        TODO("Not yet implemented")
    }

    override fun <Y : Comparable<Y>?> lessThan(x: Expression<out Y>?, y: Expression<out Y>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun <Y : Comparable<Y>?> lessThan(x: Expression<out Y>?, y: Y): Predicate {
        TODO("Not yet implemented")
    }

    override fun <Y : Comparable<Y>?> lessThanOrEqualTo(x: Expression<out Y>?, y: Expression<out Y>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun <Y : Comparable<Y>?> lessThanOrEqualTo(x: Expression<out Y>?, y: Y): Predicate {
        TODO("Not yet implemented")
    }

    override fun <Y : Comparable<Y>?> between(
        v: Expression<out Y>?,
        x: Expression<out Y>?,
        y: Expression<out Y>?
    ): Predicate {
        TODO("Not yet implemented")
    }

    override fun <Y : Comparable<Y>?> between(v: Expression<out Y>?, x: Y, y: Y): Predicate {
        TODO("Not yet implemented")
    }

    override fun gt(x: Expression<out Number>?, y: Expression<out Number>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun gt(x: Expression<out Number>?, y: Number?): Predicate {
        TODO("Not yet implemented")
    }

    override fun ge(x: Expression<out Number>?, y: Expression<out Number>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun ge(x: Expression<out Number>?, y: Number?): Predicate {
        TODO("Not yet implemented")
    }

    override fun lt(x: Expression<out Number>?, y: Expression<out Number>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun lt(x: Expression<out Number>?, y: Number?): Predicate {
        TODO("Not yet implemented")
    }

    override fun le(x: Expression<out Number>?, y: Expression<out Number>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun le(x: Expression<out Number>?, y: Number?): Predicate {
        TODO("Not yet implemented")
    }

    override fun <N : Number?> neg(x: Expression<N>?): Expression<N> {
        TODO("Not yet implemented")
    }

    override fun <N : Number?> abs(x: Expression<N>?): Expression<N> {
        TODO("Not yet implemented")
    }

    override fun <N : Number?> prod(x: Expression<out N>?, y: Expression<out N>?): Expression<N> {
        TODO("Not yet implemented")
    }

    override fun <N : Number?> prod(x: Expression<out N>?, y: N): Expression<N> {
        TODO("Not yet implemented")
    }

    override fun <N : Number?> prod(x: N, y: Expression<out N>?): Expression<N> {
        TODO("Not yet implemented")
    }

    override fun <N : Number?> diff(x: Expression<out N>?, y: Expression<out N>?): Expression<N> {
        TODO("Not yet implemented")
    }

    override fun <N : Number?> diff(x: Expression<out N>?, y: N): Expression<N> {
        TODO("Not yet implemented")
    }

    override fun <N : Number?> diff(x: N, y: Expression<out N>?): Expression<N> {
        TODO("Not yet implemented")
    }

    override fun quot(x: Expression<out Number>?, y: Expression<out Number>?): Expression<Number> {
        TODO("Not yet implemented")
    }

    override fun quot(x: Expression<out Number>?, y: Number?): Expression<Number> {
        TODO("Not yet implemented")
    }

    override fun quot(x: Number?, y: Expression<out Number>?): Expression<Number> {
        TODO("Not yet implemented")
    }

    override fun mod(x: Expression<Int>?, y: Expression<Int>?): Expression<Int> {
        TODO("Not yet implemented")
    }

    override fun mod(x: Expression<Int>?, y: Int?): Expression<Int> {
        TODO("Not yet implemented")
    }

    override fun mod(x: Int?, y: Expression<Int>?): Expression<Int> {
        TODO("Not yet implemented")
    }

    override fun sqrt(x: Expression<out Number>?): Expression<Double> {
        TODO("Not yet implemented")
    }

    override fun toLong(number: Expression<out Number>?): Expression<Long> {
        TODO("Not yet implemented")
    }

    override fun toInteger(number: Expression<out Number>?): Expression<Int> {
        TODO("Not yet implemented")
    }

    override fun toFloat(number: Expression<out Number>?): Expression<Float> {
        TODO("Not yet implemented")
    }

    override fun toDouble(number: Expression<out Number>?): Expression<Double> {
        TODO("Not yet implemented")
    }

    override fun toBigDecimal(number: Expression<out Number>?): Expression<BigDecimal> {
        TODO("Not yet implemented")
    }

    override fun toBigInteger(number: Expression<out Number>?): Expression<BigInteger> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> literal(value: T): Expression<T> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> nullLiteral(resultClass: Class<T>?): Expression<T> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> parameter(paramClass: Class<T>?): ParameterExpression<T> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> parameter(paramClass: Class<T>?, name: String?): ParameterExpression<T> {
        TODO("Not yet implemented")
    }

    override fun <C : MutableCollection<*>?> isEmpty(collection: Expression<C>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun <C : MutableCollection<*>?> isNotEmpty(collection: Expression<C>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun <C : MutableCollection<*>?> size(collection: Expression<C>?): Expression<Int> {
        TODO("Not yet implemented")
    }

    override fun <C : MutableCollection<*>?> size(collection: C): Expression<Int> {
        TODO("Not yet implemented")
    }

    override fun <E : Any?, C : MutableCollection<E>?> isMember(
        elem: Expression<E>?,
        collection: Expression<C>?
    ): Predicate {
        TODO("Not yet implemented")
    }

    override fun <E : Any?, C : MutableCollection<E>?> isMember(elem: E, collection: Expression<C>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun <E : Any?, C : MutableCollection<E>?> isNotMember(
        elem: Expression<E>?,
        collection: Expression<C>?
    ): Predicate {
        TODO("Not yet implemented")
    }

    override fun <E : Any?, C : MutableCollection<E>?> isNotMember(elem: E, collection: Expression<C>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun <V : Any?, M : MutableMap<*, V>?> values(map: M): Expression<MutableCollection<V>> {
        TODO("Not yet implemented")
    }

    override fun <K : Any?, M : MutableMap<K, *>?> keys(map: M): Expression<MutableSet<K>> {
        TODO("Not yet implemented")
    }

    override fun like(x: Expression<String>?, pattern: Expression<String>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun like(x: Expression<String>?, pattern: String?): Predicate {
        TODO("Not yet implemented")
    }

    override fun like(x: Expression<String>?, pattern: Expression<String>?, escapeChar: Expression<Char>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun like(x: Expression<String>?, pattern: Expression<String>?, escapeChar: Char): Predicate {
        TODO("Not yet implemented")
    }

    override fun like(x: Expression<String>?, pattern: String?, escapeChar: Expression<Char>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun like(x: Expression<String>?, pattern: String?, escapeChar: Char): Predicate {
        TODO("Not yet implemented")
    }

    override fun notLike(x: Expression<String>?, pattern: Expression<String>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun notLike(x: Expression<String>?, pattern: String?): Predicate {
        TODO("Not yet implemented")
    }

    override fun notLike(
        x: Expression<String>?,
        pattern: Expression<String>?,
        escapeChar: Expression<Char>?
    ): Predicate {
        TODO("Not yet implemented")
    }

    override fun notLike(x: Expression<String>?, pattern: Expression<String>?, escapeChar: Char): Predicate {
        TODO("Not yet implemented")
    }

    override fun notLike(x: Expression<String>?, pattern: String?, escapeChar: Expression<Char>?): Predicate {
        TODO("Not yet implemented")
    }

    override fun notLike(x: Expression<String>?, pattern: String?, escapeChar: Char): Predicate {
        TODO("Not yet implemented")
    }

    override fun concat(x: Expression<String>?, y: Expression<String>?): Expression<String> {
        TODO("Not yet implemented")
    }

    override fun concat(x: Expression<String>?, y: String?): Expression<String> {
        TODO("Not yet implemented")
    }

    override fun concat(x: String?, y: Expression<String>?): Expression<String> {
        TODO("Not yet implemented")
    }

    override fun substring(x: Expression<String>?, from: Expression<Int>?): Expression<String> {
        TODO("Not yet implemented")
    }

    override fun substring(x: Expression<String>?, from: Int): Expression<String> {
        TODO("Not yet implemented")
    }

    override fun substring(x: Expression<String>?, from: Expression<Int>?, len: Expression<Int>?): Expression<String> {
        TODO("Not yet implemented")
    }

    override fun substring(x: Expression<String>?, from: Int, len: Int): Expression<String> {
        TODO("Not yet implemented")
    }

    override fun trim(x: Expression<String>?): Expression<String> {
        TODO("Not yet implemented")
    }

    override fun trim(ts: CriteriaBuilder.Trimspec?, x: Expression<String>?): Expression<String> {
        TODO("Not yet implemented")
    }

    override fun trim(t: Expression<Char>?, x: Expression<String>?): Expression<String> {
        TODO("Not yet implemented")
    }

    override fun trim(ts: CriteriaBuilder.Trimspec?, t: Expression<Char>?, x: Expression<String>?): Expression<String> {
        TODO("Not yet implemented")
    }

    override fun trim(t: Char, x: Expression<String>?): Expression<String> {
        TODO("Not yet implemented")
    }

    override fun trim(ts: CriteriaBuilder.Trimspec?, t: Char, x: Expression<String>?): Expression<String> {
        TODO("Not yet implemented")
    }

    override fun lower(x: Expression<String>?): Expression<String> {
        TODO("Not yet implemented")
    }

    override fun upper(x: Expression<String>?): Expression<String> {
        TODO("Not yet implemented")
    }

    override fun length(x: Expression<String>?): Expression<Int> {
        TODO("Not yet implemented")
    }

    override fun locate(x: Expression<String>?, pattern: Expression<String>?): Expression<Int> {
        TODO("Not yet implemented")
    }

    override fun locate(x: Expression<String>?, pattern: String?): Expression<Int> {
        TODO("Not yet implemented")
    }

    override fun locate(x: Expression<String>?, pattern: Expression<String>?, from: Expression<Int>?): Expression<Int> {
        TODO("Not yet implemented")
    }

    override fun locate(x: Expression<String>?, pattern: String?, from: Int): Expression<Int> {
        TODO("Not yet implemented")
    }

    override fun currentDate(): Expression<Date> {
        TODO("Not yet implemented")
    }

    override fun currentTimestamp(): Expression<Timestamp> {
        TODO("Not yet implemented")
    }

    override fun currentTime(): Expression<Time> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> `in`(expression: Expression<out T>?): CriteriaBuilder.In<T> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> coalesce(x: Expression<out Y>?, y: Expression<out Y>?): Expression<Y> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> coalesce(x: Expression<out Y>?, y: Y): Expression<Y> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> coalesce(): CriteriaBuilder.Coalesce<T> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> nullif(x: Expression<Y>?, y: Expression<*>?): Expression<Y> {
        TODO("Not yet implemented")
    }

    override fun <Y : Any?> nullif(x: Expression<Y>?, y: Y): Expression<Y> {
        TODO("Not yet implemented")
    }

    override fun <C : Any?, R : Any?> selectCase(expression: Expression<out C>?): CriteriaBuilder.SimpleCase<C, R> {
        TODO("Not yet implemented")
    }

    override fun <R : Any?> selectCase(): CriteriaBuilder.Case<R> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> function(name: String?, type: Class<T>?, vararg args: Expression<*>?): Expression<T> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, T : Any?, V : T> treat(join: Join<X, T>?, type: Class<V>?): Join<X, V> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, T : Any?, E : T> treat(join: CollectionJoin<X, T>?, type: Class<E>?): CollectionJoin<X, E> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, T : Any?, E : T> treat(join: SetJoin<X, T>?, type: Class<E>?): SetJoin<X, E> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, T : Any?, E : T> treat(join: ListJoin<X, T>?, type: Class<E>?): ListJoin<X, E> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, K : Any?, T : Any?, V : T> treat(
        join: MapJoin<X, K, T>?,
        type: Class<V>?
    ): MapJoin<X, K, V> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, T : X> treat(path: Path<X>?, type: Class<T>?): Path<T> {
        TODO("Not yet implemented")
    }

    override fun <X : Any?, T : X> treat(root: Root<X>?, type: Class<T>?): Root<T> {
        TODO("Not yet implemented")
    }
}
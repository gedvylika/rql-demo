package net.gger.rqldemo.service.mocks

import javax.persistence.criteria.Expression
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Selection

class MockPredicate(val command: Any, val parameters: Any): Predicate {
    override fun getJavaType(): Class<out Boolean> {
        TODO("Not yet implemented")
    }

    override fun getAlias(): String {
        TODO("Not yet implemented")
    }

    override fun alias(name: String?): Selection<Boolean> {
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

    override fun getOperator(): Predicate.BooleanOperator {
        TODO("Not yet implemented")
    }

    override fun isNegated(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getExpressions(): MutableList<Expression<Boolean>> {
        TODO("Not yet implemented")
    }

    override fun not(): Predicate {
        TODO("Not yet implemented")
    }


}
package net.gger.rqldemo.service.queryevaluator

enum class SearchOperation(val parameterCount: Int) {
    NOT (1),

    AND (2),
    OR (2),
    EQUAL (2),
    GREATER_THAN (2),
    LESS_THAN (2),

    UNRECOGNIZED_OPERATION(0);

    companion object {
        fun getOperation(input: String): SearchOperation {
            return when (input.uppercase()) {
                "EQUAL" -> EQUAL
                "AND" -> AND
                "OR" -> OR
                "NOT" -> NOT
                "GREATER_THAN" -> GREATER_THAN
                "LESS_THAN" -> LESS_THAN

                else -> UNRECOGNIZED_OPERATION
            }
        }

        fun getParamCount(input: SearchOperation): Int {
            return input.parameterCount
        }
    }

}
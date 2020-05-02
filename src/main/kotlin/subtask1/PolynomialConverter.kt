package subtask1

import kotlin.math.abs

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isEmpty()) {
            return null
        }
        val result = StringBuffer()
        for (i in numbers.indices) {
            if (numbers[i] != 0) {
                val koef = numbers[i]
                val sign = if (koef > 0) " + " else " - "
                if (result.isNotEmpty() || koef < 0) {
                    result.append(sign)
                }
                if (abs(koef) != 1) {
                    result.append(abs(koef))
                }
                val degree = numbers.size - i - 1
                if (degree > 0) {
                    result.append("x")
                    if (degree > 1) {
                        result.append("^$degree")
                    }
                }
            }
        }
        return result.toString()
    }
}

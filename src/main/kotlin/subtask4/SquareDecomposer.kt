package subtask4

class SquareDecomposer {

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        val result = findArray(number, number*number)
        return result?.subList(0, result.lastIndex - 1)?.toTypedArray()
    }

    fun findArray(n: Int, remain: Int): MutableList<Int>? {
        if (remain == 0) {
            return mutableListOf(n)
        }
        for (i in n-1 downTo 0) {
            if (remain - i * i >= 0) {
                val result = findArray(i, remain - i * i)
                result?.add(n)
                return result
            }
        }
        return null
    }
}

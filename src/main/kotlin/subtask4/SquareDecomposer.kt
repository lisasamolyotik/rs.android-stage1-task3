package subtask4

class SquareDecomposer {

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        val longNumber = number.toLong()
        val result = decomposer(longNumber, longNumber * longNumber) ?: return null
        result.remove(result.last())
        return result.toTypedArray()
    }

    fun decomposer(n: Long, remain: Long): MutableList<Int>?{
        if(remain == 0L) {
            return mutableListOf(n.toInt())
        }
        for( i in n-1 downTo 0) {
            if((remain - i * i) >= 0){
                val result = decomposer(i, (remain - i * i))
                if(result != null){
                    result.add(n.toInt())
                    return result
                }
            }
        }
        return null
    }
}

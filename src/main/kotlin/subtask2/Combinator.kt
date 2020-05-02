package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        for (i in 1..array[1]) {
            if (equation(array[1], i).compareTo(array[0]) == 0) return i
        }
        return null
    }

    private fun equation(n: Int, m:Int): Long {
        return factorial(n) / (factorial(m) * factorial(n - m))
    }

    private fun factorial(n: Int): Long {
        if (n > 1) {
            return n * factorial(n-1)
        }
        return 1
    }
}

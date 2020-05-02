package subtask3

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val intList = itemsFromArray.filterIsInstance<Int>()
        if (intList.isEmpty()) {
            return 0
        }
        if (numberOfItems >= intList.size) {
            return intList.reduce{ acc, i -> acc * i}
        }
        val sortedList = intList.sortedByDescending { item -> kotlin.math.abs(item) }
        val resultList = sortedList.subList(0, numberOfItems).toMutableList()
        val others = sortedList.subList(numberOfItems, sortedList.lastIndex)
        if (resultList.count { item -> item < 0 } % 2 == 1) {
            val minNegative = resultList.filter { item -> item < 0 }.sortedDescending()[0]
            resultList[resultList.indexOf(minNegative)] = others.maxBy { item -> item > 0 }!!
        }
        return resultList.reduce { acc, i -> acc * i}
    }

}

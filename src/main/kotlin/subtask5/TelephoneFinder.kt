package subtask5

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        val result = mutableListOf<String>()
        for(i in number.indices) {
            val neighbors = findNeighbors(number[i]) ?: return null
            for (neighbor in neighbors) {
                result.add(number.substring(0 until i) + neighbor + number.substring(i + 1))
            }
        }
        return result.toTypedArray()
    }

    private fun findNeighbors(n: Char) : CharArray? {
        return when (n) {
            '0' -> charArrayOf('8')
            '1' -> charArrayOf('2', '4')
            '2' -> charArrayOf('1', '3', '5')
            '3' -> charArrayOf('2', '6')
            '4' -> charArrayOf('1', '5', '7')
            '5' -> charArrayOf('2', '4', '6', '8')
            '6' -> charArrayOf('3', '5', '9')
            '7' -> charArrayOf('4', '8')
            '8' -> charArrayOf('5', '7', '9', '0')
            '9' -> charArrayOf('6', '8')
            else -> null
        }
    }
}

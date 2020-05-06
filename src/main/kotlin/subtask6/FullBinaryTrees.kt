package subtask6

class FullBinaryTrees {

    private var storage = mutableListOf<String>()

    fun stringForNodeCount(count: Int): String {
        if (count % 2 == 0) {
            return "[]"
        }
        if (count == 1) {
            return "[[0]]"
        }

        val array = combinations(count)
        var result = mutableListOf<String>()

        for(node in array) {
            storage = mutableListOf()
            levelOrderTraversal(node)
            while(storage.last() == "null") {
                storage.remove(storage.last())
            }
            val subResult = storage.joinToString(separator = ",", prefix = "[", postfix = "]")
            result.add(subResult)
        }
        return result.joinToString(separator = ",\n", prefix = "[\n", postfix = "\n]")
    }

    private fun combinations(remain: Int): MutableList<Node> {
        val result = mutableListOf<Node>()
        if (remain == 1) {
            result.add(Node())
            return result
        }

        for(i in 1 until remain) {
            if(i == 2 || remain - i - 1 == 2) continue
            val left = combinations(i)
            val right = combinations(remain - i - 1)
            for(l in left) {
                for (r in right) {
                    result.add(Node(left = l, right = r))
                }
            }
        }
        return result
    }

    private fun getLevel(root: Node?, level: Int): Boolean {
        if(root == null) {
            return false
        }
        if (level == 1) {
            storage.add(root.key)
            return true
        }

        val left = getLevel(root.left, level - 1)
        val right = getLevel(root.right, level - 1)
        return left || right
    }

    private fun levelOrderTraversal(root: Node?) {
        var level = 1
        while(getLevel(root, level++)) {}
    }
}


class Node(
    var key: String = "0",
    var left: Node? = Node(key = "null", left = null, right = null),
    var right: Node? = Node(key = "null", left = null, right = null)
)
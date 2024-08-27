object Solution {
    // O(n) space | O(n) space
    fun twoNumberSum(array: List<Int>, targetSum: Int): List<Int> {
        val numSet = array.toSet()

        for (current in array) {
            val left = targetSum - current
            if (left in numSet && left != current)
                return listOf(current, left)
        }

        return listOf<Int>()
    }
}

object Test {

    data class TestCase(
        val array: List<Int>,
        val targetSum: Int,
        val expected: List<Int>
    )

    val testCases = listOf(
        TestCase(
            array = listOf(3, 5, -4, 8, 11, 1, -1, 6),
            targetSum = 10,
            expected = listOf(11, -1)
        ),
        TestCase(
            array = listOf(4, 6),
            targetSum = 10,
            expected = listOf(4, 6)
        ),
        TestCase(
            array = listOf(4, 6, 1),
            targetSum = 5,
            expected = listOf(4, 1)
        ),
        TestCase(
            array = listOf(4, 6, 1, -3),
            targetSum = 3,
            expected = listOf(6, -3)
        )
    )

    fun run() {
        for (test in testCases) {
            val result = Solution.twoNumberSum(test.array, test.targetSum)
            assert(result == test.expected)
        }
    }
}

Test.run()

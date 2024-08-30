import kotlin.math.abs

object NaiveSolution {
    // O(n log(n)) time | O(n) space
    fun sortedSquaredArray(array: List<Int>): List<Int> {
        return array.map { it * it }.sorted()
    }
}

object OptimalSolution {
    // O(n) time | O(n) space
    fun sortedSquaredArray(array: List<Int>): List<Int> {
        var leftIdx = 0
        var rightIdx = array.lastIndex
        val squares = IntArray(array.size)
        var nextPosToFill = squares.lastIndex

        while (leftIdx <= rightIdx) {
            val l = abs(array[leftIdx])
            val r = abs(array[rightIdx])

            if (l > r) {
                squares[nextPosToFill] = l * l
                leftIdx++
            }
            else {
                squares[nextPosToFill] = r * r
                rightIdx--            
            }

            nextPosToFill--
        }

        return squares.toList()
    }
}

object Test {

    data class TestCase(
        val array: List<Int>,
        val expected: List<Int>
    )

    val testCases = listOf(
        TestCase(
            array = listOf(1, 2, 3, 5, 6, 8, 9),
            expected = listOf(1, 4, 9, 25, 36, 64, 81)
        ),
        TestCase(
            array = listOf(1),
            expected = listOf(1)
        ),
        TestCase(
            array = listOf(-10, -5, 0, 5, 10),
            expected = listOf(0, 25, 25, 100, 100)
        ),
        TestCase(
            array = listOf(-1, -1, 2, 3, 3, 3, 4),
            expected = listOf(1, 1, 4, 9, 9, 9, 16)
        )
    )

    fun run() {
        for (test in testCases) {
            val naiveResult = NaiveSolution.sortedSquaredArray(test.array)
            val optimalResult = OptimalSolution.sortedSquaredArray(test.array)
            assert(naiveResult == test.expected)
            assert(optimalResult == test.expected)
        }
    }
}

Test.run()

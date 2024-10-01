object OptimalSolution {
    // O(n) time | O(n) space
    fun riverSizes(matrix: List<List<Int>>): List<Int> {
        val visited = mutableListOf<Pair<Int,Int>>()
        val result = mutableListOf<Int>()

        for (row in matrix.indices) {
            for (col in matrix[row].indices) {
                if (matrix[row][col] != 0) {
                    val count = count(matrix, row, col, visited)
                    if (count > 0) result.add(count)
                }
            }
        }

        return result
    }

    private fun count(matrix: List<List<Int>>, row: Int, col: Int, visited: MutableList<Pair<Int,Int>>): Int {
        if (Pair(row, col) in visited || isOutOfBound(matrix, row, col) || matrix[row][col] == 0)
            return 0

        visited.add(Pair(row, col))

        // count left
        val countLeft = count(matrix, row, col - 1, visited)
        // count down
        val countDown = count(matrix, row + 1, col, visited)
        // count right
        val countRight = count(matrix, row, col + 1, visited)
        // count top
        val countTop = count(matrix, row - 1, col, visited)

        return 1 + countLeft + countDown + countRight + countTop
    }

    private fun isOutOfBound(matrix: List<List<Int>>, row: Int, col: Int) =
        row !in matrix.indices || col !in matrix[row].indices
}

object Test {
    data class TestCase(
        val matrix: List<List<Int>>,
        val expected: List<Int>
    )

    val testCases = listOf(
        TestCase(
            matrix = listOf(
                listOf(1, 0, 0, 1, 0),
                listOf(1, 0, 1, 0, 0),
                listOf(0, 0, 1, 0, 1),
                listOf(1, 0, 1, 0, 1),
                listOf(1, 0, 1, 1, 0),
            ),
            expected = listOf(1, 2, 2, 2, 5)
        ),
        TestCase(
            matrix = listOf(
                listOf(1, 1, 1, 1, 1, 1, 1),
                listOf(1, 1, 1, 1, 1, 1, 1),
                listOf(1, 1, 1, 1, 1, 1, 1),
                listOf(1, 1, 1, 1, 1, 1, 1),
                listOf(1, 1, 1, 1, 1, 1, 1),
                listOf(1, 1, 1, 1, 1, 1, 1),
                listOf(1, 1, 1, 1, 1, 1, 1),
            ),
            expected = listOf(49)
        ),
        TestCase(
            matrix = listOf(
                listOf(0, 0, 0, 0, 0, 0, 0),
                listOf(0, 0, 0, 0, 0, 0, 0),
                listOf(0, 0, 0, 0, 0, 0, 0),
                listOf(0, 0, 0, 0, 0, 0, 0),
                listOf(0, 0, 0, 0, 0, 0, 0),
                listOf(0, 0, 0, 0, 0, 0, 0),
                listOf(0, 0, 0, 0, 0, 0, 0),
            ),
            expected = listOf()
        ),
        TestCase(
            matrix = listOf(
                listOf(1, 1, 0, 0, 0, 0, 1, 1),
                listOf(1, 0, 1, 1, 1, 1, 0, 1),
                listOf(0, 1, 1, 0, 0, 0, 1, 1),
            ),
            expected = listOf(3, 5, 6)
        ),
    )

    fun run() {
        for (test in testCases) {
            val result = OptimalSolution.riverSizes(test.matrix)
            assert(result.sorted() == test.expected.sorted())
        }
    }
}

Test.run()
object OptimalSolution {
    // O(n) time | O(1) space
    fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
        if (sequence.size > array.size) return false
        
        var numbers = array
        for (seq in sequence) {
            if (numbers.indexOf(seq) == -1) return false
            numbers = numbers.subList(numbers.indexOf(seq).plus(1), numbers.size)
        }
        
        return true
    }
}

object Test {
    data class TestCase(
        val array: List<Int>,
        val sequence: List<Int>,
        val expected: Boolean
    )

    val testCases = listOf(
        TestCase(
            array = listOf(5, 1, 22, 25, 6, -1, 8, 10),
            sequence = listOf(1, 6, -1, 10),
            expected = true
        ),
        TestCase(
            array = listOf(5, 1, 22, 25, 6, -1, 8, 10),
            sequence = listOf(5, 1, 22, 10),
            expected = true
        ),
        TestCase(
            array = listOf(5, 1, 22, 25, 6, -1, 8, 10),
            sequence = listOf(5, 1, 22, 25, 6, -1, 8, 10, 10),
            expected = false
        ),
        TestCase(
            array = listOf(5, 1, 22, 25, 6, -1, 8, 10),
            sequence = listOf(25),
            expected = true
        ),
    )

    fun run() {
        for (test in testCases) {
            val result = OptimalSolution.isValidSubsequence(test.array, test.sequence)
            assert(result == test.expected)
        }
    }
}

Test.run()

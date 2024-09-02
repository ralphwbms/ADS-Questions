object OptimalSolution {
    // O(n) time | O(k) space - where n is the number of matches and k is the number of teams
    fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
        val winPoints = 3
        val scoreBoard = mutableMapOf<String, Int>()
        val winnerIndex = mapOf("1" to 0, "0" to 1)
        
        for ((index, match) in competitions.withIndex()) {
            val matchResult = results[index]
            val winner = match[winnerIndex[matchResult.toString()]!!]
            scoreBoard[winner] = scoreBoard.getOrDefault(winner, 0) + winPoints
        }
        
        return scoreBoard.maxBy{ it.value }.key
    }
}

object Test {
    data class TestCase(
        val competitions: List<List<String>>,
        val results: List<Int>,
        val expected: String
    )

    val testCases = listOf(
        TestCase(
            competitions = listOf(
                listOf("HTML", "C#"),
                listOf("C#", "Python"),
                listOf("Python", "HTML")
            ),
            results = listOf(0, 0, 1),
            expected = "Python"
        ),
        TestCase(
            competitions = listOf(
                listOf("AlgoMasters", "FrontPage Freebirds"),
                listOf("Runtime Terror", "Static Startup"),
                listOf("WeC#", "Hypertext Assassins"),
                listOf("AlgoMasters", "WeC#"),
                listOf("Static Startup", "Hypertext Assassins"),
                listOf("Runtime Terror", "FrontPage Freebirds"),
                listOf("AlgoMasters", "Runtime Terror"),
                listOf("Hypertext Assassins", "FrontPage Freebirds"),
                listOf("Static Startup", "WeC#"),
                listOf("AlgoMasters", "Static Startup"),
                listOf("FrontPage Freebirds", "WeC#"),
                listOf("Hypertext Assassins", "Runtime Terror"),
                listOf("AlgoMasters", "Hypertext Assassins"),
                listOf("WeC#", "Runtime Terror"),
                listOf("FrontPage Freebirds", "Static Startup")
            ),
            results = listOf(1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0),
            expected = "AlgoMasters"
        )
    )

    fun run() {
        for (test in testCases) {
            val result = NaiveSolution.tournamentWinner(test.competitions, test.results)
            assert(result == test.expected)
        }
    }
}

Test.run()

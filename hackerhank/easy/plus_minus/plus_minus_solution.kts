fun plusMinus(arr: List<Int>): List<String> {
    val pos = arr.count { it > 0 }
    val neg = arr.count { it < 0 }
    val zer = arr.size - pos - neg

    return listOf(
        "%.6f".format(pos.toFloat() / arr.size),
        "%.6f".format(neg.toFloat() / arr.size),
        "%.6f".format(zer.toFloat() / arr.size)
    )
}


fun main() {
    val given = listOf(0, 4, -3, 3, -6)
    val expected = listOf("0.400000", "0.400000", "0.200000")
    val actual = plusMinus(given)
    assert(actual == expected)
}

// install kotlinc and then run: kotlinc -J-ea -script plus_minus_solution.kts
main()

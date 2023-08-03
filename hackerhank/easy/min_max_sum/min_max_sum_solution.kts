// O(n log n) time | O(n) space
fun miniMaxSum(arr: Array<Int>): Array<Long> {
    arr.sort()
    val sum = arr.sumOf{ it.toLong() }
    val min = sum - arr.last()
    val max = sum - arr.first()
    return arrayOf(min, max)
}

fun main() {
    val given = arrayOf(140638725, 436257910, 953274816, 734065819, 362748590)
    val expected = arrayOf(1673711044, 2486347135)
    val actual = miniMaxSum(given)
    assert(actual.contentEquals(expected))
}

main()

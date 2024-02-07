@file:Import("Solution.kts")

data class TestCase(
    val h1: String,
    val h2: String,
    val expected: String
)

fun String.toSinglyLinkedListNode(): SinglyLinkedListNode? {
    if (this.isEmpty()) return null
    
    val values = this.split(" ").map { it.toInt() }
    val head = SinglyLinkedListNode(0)
    var current = head

    values.forEach { v ->
        current.next = SinglyLinkedListNode(v)
        current = current.next!!
    }

    return head.next
}

fun main() {
    val testCases = listOf(
        TestCase(
            h1 = "1 3 7",
            h2 = "1 2",
            expected = "1 1 2 3 7"
        ),
        TestCase(
            h1 = "1 2 3",
            h2 = "3 4",
            expected = "1 2 3 3 4"
        ),
        TestCase(
            h1 = "4 5 6",
            h2 = "1 2 10",
            expected = "1 2 4 5 6 10"
        ),
        TestCase(
            h1 = "1",
            h2 = "1",
            expected = "1 1"
        ),
        TestCase(
            h1 = "10 23 34 87 156",
            h2 = "12 24 88 157",
            expected = "10 12 23 24 34 87 88 156 157"
        )
    )

    testCases.forEach { tc ->
        val h1 = tc.h1.toSinglyLinkedListNode()
        val h2 = tc.h2.toSinglyLinkedListNode()

        val actualRecursive = RecursiveSolution.mergeLists(h1, h2).toString()

        assert(actualRecursive == tc.expected)
    }

    testCases.forEach { tc ->
        val h1 = tc.h1.toSinglyLinkedListNode()
        val h2 = tc.h2.toSinglyLinkedListNode()

        val actualIterative = IterativeSolution.mergeLists(h1, h2).toString()

        assert(actualIterative == tc.expected)
    }
}

main()

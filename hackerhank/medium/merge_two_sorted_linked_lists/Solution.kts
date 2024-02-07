import java.util.Scanner

class SinglyLinkedListNode(val data: Int) {
    var next: SinglyLinkedListNode? = null

    fun setNext(nodeData: Int): SinglyLinkedListNode {
        next = SinglyLinkedListNode(nodeData)
        return next!!
    }

    override fun toString(): String {
        val list = mutableListOf<Int>()
        var current = this

        while (true) {
            list.add(current.data)
            current = current.next ?: break
        }

        return list.joinToString(" ")
    }
}

object IterativeSolution {
    // O(n) time | O(1) space
    fun mergeLists(hA: SinglyLinkedListNode?, hB: SinglyLinkedListNode?): SinglyLinkedListNode? {
        if (hA == null) return hB
        if (hB == null) return hA
        
        var nextA = hA
        var nextB = hB
        var header = SinglyLinkedListNode(0)
        var current = header
        
        while (nextA != null && nextB != null) {
            if (nextA.data <= nextB.data) {
                current.next = nextA
                current = current.next!!
                nextA = nextA.next
            } else {
                current.next = nextB
                current = current.next!!
                nextB = nextB.next
            }
        }

        if (nextA == null)
            current.next = nextB
        else
            current.next = nextA

        return header.next
    }
}

object RecursiveSolution {
    // O(n) time | O(n) space
    fun mergeLists(hA: SinglyLinkedListNode?, hB: SinglyLinkedListNode?): SinglyLinkedListNode? {
        if (hA == null) return hB
        if (hB == null) return hA

        if (hA.data <= hB.data) {
            hA.next = mergeLists(hA.next, hB)
            return hA
        } else {
            hB.next = mergeLists(hB.next, hA)
            return hB
        }
    }   
}

fun main() {
    val scanner = Scanner(System.`in`)
    val testCases = scanner.nextInt()

    repeat(testCases) {
        val n1 = scanner.nextInt()
        val head1 = SinglyLinkedListNode(scanner.nextInt())
        var current1 = head1
        repeat(n1 - 1) {
            current1.next = SinglyLinkedListNode(scanner.nextInt())
            current1 = current1.next!!
        }

        val n2 = scanner.nextInt()
        val head2 = SinglyLinkedListNode(scanner.nextInt())
        var current2 = head2
        repeat(n2 - 1) {
            current2.next = SinglyLinkedListNode(scanner.nextInt())
            current2 = current2.next!!
        }

        val result = IterativeSolution.mergeLists(head1, head2)
        println(result)
    }
}

# This is an input class. Do not edit.
class LinkedList:
    def __init__(self, value):
        self.value = value
        self.next = None

    def __str__(self) -> str:
        llstr = []
        ll = self
        while ll:
            llstr.append(str(ll.value))
            ll = ll.next
        return ' --> '.join(llstr)

    def __eq__(self, o: object) -> bool:
        if not isinstance(o, LinkedList): return False
        ll1 = self
        ll2 = o
        while ll1 and ll2:
            if ll1.value != ll2.value:
                return False
            ll1 = ll1.next
            ll2 = ll2.next
        return ll1 is None and ll2 is None


# O(n) time | O(1) space
def reverseLinkedList(head):
    prev = None
    curr = head
    while curr:
        next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    return prev

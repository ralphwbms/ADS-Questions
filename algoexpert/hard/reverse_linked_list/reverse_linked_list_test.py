import  reverse_linked_list_solution as solution


def linked_list_to_string(ll):
    while ll:
        print(ll.value, '--> ', end='')
        ll = ll.next
    print('None')


def linked_list_from_list(l):
    head = solution.LinkedList(l[0])
    ll = head
    for i in range(1, len(l)):
        ll.next = solution.LinkedList(l[i])
        ll = ll.next
    return head


if __name__ == '__main__':
    tests = [
        (
            linked_list_from_list([0, 1, 2, 3, 4, 5]),
            linked_list_from_list([5, 4, 3, 2, 1, 0]),
        ),
        (
            linked_list_from_list([0, 1]),
            linked_list_from_list([1, 0]),
        ),
        (
            linked_list_from_list([1]),
            linked_list_from_list([1]),
        ),
        (
            linked_list_from_list(['a', 'b', 'c', 'd', 'e']),
            linked_list_from_list(['e', 'd', 'c', 'b', 'a']),
        ),
    ]
    
    for input, expected in tests:
        assert solution.reverseLinkedList(input) == expected

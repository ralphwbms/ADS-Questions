"""
O(n) space | O(1) time

Explanation
O(n) time complexity:
It uses a set to track what number have already been found.

O(1) space complexity:
As the iteration goes on, elements are removed from the array
and inserted into the set, making the space constant.
"""
def firstDuplicateValue(array):
    s = set()
    while len(array) > 0:
        n = array.pop(0)
        if n in s:
            return n
        s.add(n)
    return -1


if __name__ == "__main__":
    assert firstDuplicateValue([2, 1, 5, 2, 3, 3, 4]) == 2
    assert firstDuplicateValue([2, 1, 5, 3, 3, 2, 4]) == 3

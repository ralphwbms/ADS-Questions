# O(n) time | O(1) space
def subarraySort(array):
    prev_ordered = array[0]
    min_unordered_value = float('inf')
    min_unordered_index = -1
    max_unordered_index = -1

    for i in range(len(array)):
        if array[i] < prev_ordered:
            min_unordered_value = min(min_unordered_value, array[i])
            max_unordered_index = i
        else:
            prev_ordered = array[i]

    if max_unordered_index:
        for i, v in enumerate(array):
            if min_unordered_value < v:
                min_unordered_index = i
                break

    return [min_unordered_index, max_unordered_index]

import subarray_sort_solution as solution


if __name__ == '__main__':
    tests = [
        ([1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19], [3, 9]),
        ([1, 2], [-1, -1]),
        ([2, 1], [0, 1]),
        ([1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19], [4, 9]),
    ]

    for input, expected in tests:
        assert solution.subarraySort(input) == expected

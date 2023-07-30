def plusMinus(arr):
    count = len(arr)
    pos = sum(1 for n in arr if n > 0)
    neg = sum(1 for n in arr if n < 0)
    zer = count - pos - neg
    
    return [
        f'{pos/count:6f}',
        f'{neg/count:6f}',
        f'{zer/count:6f}'
    ]


if __name__ == '__main__':
    given = [0, 4, -3, 3, -6]
    expected = ["0.400000", "0.400000", "0.200000"]
    actual = plusMinus(given)
    assert actual == expected

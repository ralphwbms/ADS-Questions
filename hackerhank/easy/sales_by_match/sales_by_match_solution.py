# O(n) time | O(1) space
def sockMerchantLong(n, ar):
    element_set = set(ar)
    total_pairs = 0
    for p in element_set:
        total_pairs += ar.count(p) // 2
    return total_pairs


# O(n) time | O(1) space
def sockMerchantShort(n, ar):
    return sum([ar.count(p)//2 for p in set(ar)])


if __name__ == '__main__':
    given = [1, 2, 4, 5, 2, 7, 1, 8, 7]
    assert sockMerchantShort(len(given), given) == 3

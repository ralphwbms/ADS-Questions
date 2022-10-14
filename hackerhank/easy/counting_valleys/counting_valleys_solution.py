# O(n) time | O(1) space
def countingValleys(steps, path):
    curr_alt = 0
    valleys = 0

    for s in path:
        if s == 'U':
            curr_alt += 1
        else:
            curr_alt -= 1
            if curr_alt == -1: valleys += 1
    return valleys


if __name__ == '__main__':
    path = 'DDUUUUDD'
    expected = 1
    result = countingValleys(len(path), path)
    assert result == expected

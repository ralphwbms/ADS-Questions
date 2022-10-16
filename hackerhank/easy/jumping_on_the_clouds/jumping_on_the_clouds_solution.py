"""
You can imagine as if the 1's along the way are like penalties
that will restrict your next jump to a one cloud jump only
instead of the normal two cloud jumps:
"""
# O(n) time | O(1) space
def jumpingOnClouds(c):
    pos = 0
    jumps = 0
    while pos < len(c) - 1:
        if c[pos] == 1:
            pos -= 1 # penalt
        pos += 2
        jumps += 1
    return jumps


if __name__ == '__main__':
    assert jumpingOnClouds([0, 0, 1, 0, 0, 1, 0]) == 4

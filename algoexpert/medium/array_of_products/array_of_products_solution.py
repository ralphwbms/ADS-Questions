# O(n^2) time | O(n) space
def arrayOfProducts(array):
    r = []
    for i, _ in enumerate(array):
        r.append(_multiply(array, i))
    return r


def _multiply(array, excluded_index):
    r = 1
    for i, v in enumerate(array):
        if i != excluded_index:
            r *= v
    return r


if __name__ == "__main__":
    assert arrayOfProducts([5, 1, 4, 2]) == [8, 40, 10, 20]

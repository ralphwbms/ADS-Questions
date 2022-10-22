def get_neighbor_addresses(li, ci, matrix):
    offset = [(0, 1), (1, 0), (0, -1), (-1, 0)]

    neighbors = [
        (li+l, ci+c) for l, c in offset \
            if 0 <= li+l <= len(matrix)-1 and 0 <= ci+c <= len(matrix[li+l])-1
    ]

    return neighbors


def map_connected_land(li, ci, matrix):
    """Mark each connected land cel with the number 2"""
    if matrix[li][ci] != 1:
        return

    matrix[li][ci] = 2

    for neib_line, neib_column in get_neighbor_addresses(li, ci, matrix):
        if matrix[neib_line][neib_column] == 1:
            map_connected_land(neib_line, neib_column, matrix)


def replace_matrix_values(matrix, substitution_list):
    for line in range(len(matrix)):
        for col in range(len(matrix[line])):
            for pattern, new_value in substitution_list:
                if matrix[line][col] == pattern: matrix[line][col] = new_value
    return matrix


def is_at_the_border(lin, col, matrix):
    return lin == 0 or lin == (len(matrix)) - 1 or col == 0 or col == len(matrix[lin]) - 1


# O(wh) time | O(1) space - where w and h are the width and height of the matrix
def removeIslands(matrix):
    for l in range(len(matrix)):
        for c in range(len(matrix[l])):
            if is_at_the_border(l, c, matrix):
                map_connected_land(l, c, matrix)
    return replace_matrix_values(matrix, [(1, 0), (2, 1)])


if __name__ == '__main__':
    input = [
        [1, 0, 0, 0, 0, 0],
        [0, 1, 0, 1, 1, 1],
        [0, 0, 1, 0, 1, 0],
        [1, 1, 0, 0, 1, 0],
        [1, 0, 1, 1, 0, 0],
        [1, 0, 0, 0, 0, 1],
    ]
    expected = [
        [1, 0, 0, 0, 0, 0],
        [0, 0, 0, 1, 1, 1],
        [0, 0, 0, 0, 1, 0],
        [1, 1, 0, 0, 1, 0],
        [1, 0, 0, 0, 0, 0],
        [1, 0, 0, 0, 0, 1],
    ]

    result = removeIslands(input)
    assert result == expected

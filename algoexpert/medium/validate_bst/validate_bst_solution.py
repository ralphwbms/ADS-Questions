class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


# O(n) time | O(d) space
# where:
# - n is the number of nodes in the tree
# - d is the depth of the tree
def validateBst(tree, min_value=float('-inf'), max_value=float('inf')):
    if tree is None:
        return True
    if tree.value < min_value or tree.value > max_value:
        return False

    left_valid = validateBst(tree.left, min_value=min_value, max_value=tree.value-1)
    right_valid = validateBst(tree.right, min_value=tree.value, max_value=max_value)

    return left_valid and right_valid


if __name__ == '__main__':
    bst = BST(10)
    bst.left = BST(5)
    bst.left.left = BST(2)
    bst.left.right = BST(5)
    bst.left.left.left = BST(1)
    bst.right = BST(15)
    bst.right.left = BST(13)
    bst.right.right = BST(22)
    bst.right.left.right = BST(14)
    
    assert validateBst(bst)

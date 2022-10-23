import os


# O(n) time | O(1) space
def is_balanced(s):
    stack = []
    pairs = { '{': '}', '[': ']', '(': ')' }
    if len(s) % 2 > 0: return 'NO'
    for c in s:
        if c in pairs:
            stack.append(c)
        elif not stack or c != pairs.get(stack.pop()):
                return 'NO'
    return 'NO' if len(stack) else 'YES'


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        s = input()

        result = is_balanced(s)

        fptr.write(result + '\n')

    fptr.close()

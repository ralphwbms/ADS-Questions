class Solution:
    # O(n log n) time | O(1) space
    def firstMissingPositive(self, nums: list[int]) -> int:
        nums.sort()
        missing = 1
        for _, v in enumerate(nums):
            if missing == v:
                missing += 1
            elif v > missing:
                break
        return missing


if __name__ == '__main__':
    solution = Solution()
    assert solution.firstMissingPositive([3, 4, -1, 1]) == 2
    assert solution.firstMissingPositive([7, 3, 1, 20, 2, 4, -1]) == 5
    assert solution.firstMissingPositive([1, 1]) == 2
    assert solution.firstMissingPositive([3,4,-1,1]) == 2
    assert solution.firstMissingPositive([7,8,9,11,12]) == 1

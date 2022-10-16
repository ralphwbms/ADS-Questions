class Solution:
    # O(n) time | O(1) space
    def firstMissingPositive(self, nums: list[int]) -> int:
        curr_pos = 0
        max_value = len(nums)
        
        while curr_pos < len(nums):
            curr_value = nums[curr_pos]
            correct_pos = curr_value - 1
            if curr_value < 1 or curr_value > max_value or curr_value == nums[correct_pos]:
                curr_pos += 1
            else:
                nums[correct_pos], nums[curr_pos] = nums[curr_pos], nums[correct_pos]

        missing = 1
        for _, v in enumerate(nums):
            if missing == v:
                missing += 1
            else:
                break
        return missing


if __name__ == '__main__':
    solution = Solution()
    assert solution.firstMissingPositive([3, 4, -1, 1]) == 2
    assert solution.firstMissingPositive([7, 3, 1, 20, 2, 4, -1]) == 5
    assert solution.firstMissingPositive([1, 1]) == 2
    assert solution.firstMissingPositive([3,4,-1,1]) == 2
    assert solution.firstMissingPositive([7,8,9,11,12]) == 1

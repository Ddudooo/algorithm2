package study.algorithm.leetcode.easy.remove_duplicates_from_sorted_array

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var pointer = 0
        for (i in 1 until nums.size) {
            if (nums[pointer] != nums[i]) {
                nums[++pointer] = nums[i]
            }
        }
        return ++pointer
    }
}

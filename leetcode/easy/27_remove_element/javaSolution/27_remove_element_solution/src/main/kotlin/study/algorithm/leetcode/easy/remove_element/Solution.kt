package study.algorithm.leetcode.easy.remove_element

class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var targetIdx = 0
        nums.forEach { if(it!=`val`) nums[targetIdx++] = it }
        return targetIdx
    }
}

package study.algorithm.leetcode.medium.problem_31

class Solution {
    fun nextPermutation(nums: IntArray) {

        // 내림차순 정렬이 되지 않는 위치까지 찾음 - 1
        var point = -1
        for ( i in nums.lastIndex downTo 1){
            if(nums[i] > nums[i-1]) {
                point = i-1
                break
            }
        }

        // 정렬이 안되어 있으면
        if(point >= 0) {
            // 1에서 찾은 위치전까지 역순으로 순회하며 1에서 찾은 위치 값보다 큰값이 있을 경우 위치 변경
            for (i in nums.lastIndex downTo point + 1) {
                if (nums[point] < nums[i]) {
                    nums.swap(point, i)
                    break
                }
            }
        }

        // 전체 뒤집음
        var left = point.inc()
        var right = nums.lastIndex

        while(left < right) {
            nums.swap(left, right)
            left = left.inc()
            right = right.dec()
        }
    }

    // 위치 변환
    private fun IntArray.swap(from: Int, to: Int) {this[from] = this[to].also { this[to] = this[from] }}
}

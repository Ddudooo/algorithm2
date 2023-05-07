package study.algorithm.leetcode.medium.problem_29

import java.math.RoundingMode.DOWN
import kotlin.math.pow

class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
        val MIN = (-2.0).pow(31).toBigDecimal()
        val MAX = ((2.0).pow(31) - 1).toBigDecimal()

        val result = dividend.toBigDecimal().divide(divisor.toBigDecimal(), 0, DOWN)

        return result.max(MIN).min(MAX).toInt()
    }
}

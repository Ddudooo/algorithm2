package study.algorithm2.leetcode.medium.generate_parentheses

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SolutionTest {
    @Test
    fun testCase1Test() {
        val solution = Solution()

        val result = solution.generateParenthesis(3)

        assertEquals(mutableListOf("((()))", "(()())", "(())()", "()(())", "()()()").sorted(), result.sorted())
    }

    @Test
    fun testCase2Test() {
        val solution = Solution()

        val result = solution.generateParenthesis(1)

        assertEquals(mutableListOf("()").sorted(), result.sorted())
    }
}
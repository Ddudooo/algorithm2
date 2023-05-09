package study.algorithm.leetcode.medium.problem_31

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import org.junit.jupiter.api.assertDoesNotThrow


class SolutionTest: StringSpec({
    "정상적으로 생성되어야 한다" {
        assertDoesNotThrow { Solution() }
    }

    "입력값이 1,2,3일때 결과로 1,3,2가 나와야 한다" {
        val nums : IntArray = intArrayOf(1,2,3)

        Solution().nextPermutation(nums)

        nums.toList().shouldContainExactly(listOf(1,3,2))
    }

    "입력값이 3,2,1 일때 결과로 1,2,3가 나와야 한다" {
        val nums : IntArray = intArrayOf(3,2,1)

        Solution().nextPermutation(nums)

        nums.toList().shouldContainExactly(listOf(1,2,3))
    }

    "입력값이 1,1,5 일때 결과로 1,5,1가 나와야 한다" {
        val nums : IntArray = intArrayOf(1,1,5)

        Solution().nextPermutation(nums)

        nums.toList().shouldContainExactly(listOf(1,5,1))
    }
})

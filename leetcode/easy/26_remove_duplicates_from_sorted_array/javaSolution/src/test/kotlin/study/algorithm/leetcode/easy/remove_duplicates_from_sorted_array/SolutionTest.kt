package study.algorithm.leetcode.easy.remove_duplicates_from_sorted_array

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SolutionTest :StringSpec({
    "정상적으로 함수가 실행되어야 한다" {
        val solution = Solution()

        shouldNotThrow<Exception> {
            solution.removeDuplicates(intArrayOf(1, 1, 2))
        }
    }

    "expect 1에 대한 결과" {
        val solution = Solution()

        val result = solution.removeDuplicates(intArrayOf(1, 1, 2))

        result shouldBe 2
    }

    "expect 2에 대한 결과" {
        val solution = Solution()

        val result = solution.removeDuplicates(intArrayOf(0,0,1,1,1,2,2,3,3,4))

        result shouldBe 5
    }

    "expect single array" {
        val solution = Solution()

        val result = solution.removeDuplicates(intArrayOf(1))

        result shouldBe 1
    }

    "expect minus contain array" {
        val solution = Solution()

        val nums = intArrayOf(-3,-1,0,0,0,3,3)
        val result = solution.removeDuplicates(nums)

        result shouldBe 4
        nums shouldBe intArrayOf(-3,-1,0,3,0,3,3)
    }
})

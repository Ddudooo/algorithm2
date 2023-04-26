package study.algorithm.leetcode.easy.problem_28

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class SolutionTest: StringSpec({
    "정상적으로 구성되어야 한다" {
        shouldNotThrow<Exception> {
            Solution()
        }
    }

    "입력으로 sadbutsad, sad가 주어질때 반환값으로 0을 반환해야 한다" {
        val haystack = "sadbutsad"
        val needle = "sad"
        val expected = 0
        val actual = Solution().strStr(haystack, needle)
        actual shouldBe expected
    }

    "입력으로 leetcode, leeto가 주어질때 반환값으로 -1을 반환해야 한다" {
        val haystack = "leetcode"
        val needle = "leeto"
        val expected = -1
        val actual = Solution().strStr(haystack, needle)
        actual shouldBe expected
    }
})

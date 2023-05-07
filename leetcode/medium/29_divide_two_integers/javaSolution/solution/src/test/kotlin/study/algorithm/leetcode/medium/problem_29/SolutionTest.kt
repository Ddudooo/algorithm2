package study.algorithm.leetcode.medium.problem_29

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertDoesNotThrow

@DisplayName("문제 풀이 요구사항")
class SolutionTest: StringSpec({
    "정상적으로 인스턴스를 생성할 수 있어야 한다" {
        assertDoesNotThrow { Solution() }
    }

    "10, 3이 주어질때 반환 값으로는 3이 나와야 한다" {
        Solution().divide(10, 3) shouldBe 3
    }

    "7, -3이 주어질때 반환 값으로는 -2가 나와야 한다" {
        Solution().divide(7, -3) shouldBe -2
    }
    "-2147483648,-1이 주어질때 반환값으로 2147483648가 나와야 한다" {
        Solution().divide(-2147483648, -1) shouldBe 2147483647
    }
})

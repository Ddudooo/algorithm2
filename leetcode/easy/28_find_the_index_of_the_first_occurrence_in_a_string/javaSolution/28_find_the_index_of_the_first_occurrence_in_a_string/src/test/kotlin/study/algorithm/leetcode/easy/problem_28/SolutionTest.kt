package study.algorithm.leetcode.easy.problem_28

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec

class SolutionTest: StringSpec({
    "정상적으로 구성되어야 한다" {
        shouldNotThrow<Exception> {
            Solution()
        }
    }
})

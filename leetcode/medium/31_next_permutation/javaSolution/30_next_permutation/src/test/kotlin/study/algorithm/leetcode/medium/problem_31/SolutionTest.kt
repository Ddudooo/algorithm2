package study.algorithm.leetcode.medium.problem_31

import io.kotest.core.spec.style.StringSpec
import org.junit.jupiter.api.assertDoesNotThrow

class SolutionTest: StringSpec({
    "정상적으로 생성되어야 한다" {
        assertDoesNotThrow { Solution() }
    }
})

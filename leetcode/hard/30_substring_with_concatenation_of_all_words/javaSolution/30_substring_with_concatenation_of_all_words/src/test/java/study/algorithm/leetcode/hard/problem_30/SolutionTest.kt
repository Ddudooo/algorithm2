package study.algorithm.leetcode.hard.problem_30

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveSize
import org.junit.jupiter.api.assertDoesNotThrow

class SolutionTest: StringSpec({
    "정상적으로 구성되어야 한다" {
        assertDoesNotThrow { Solution() }
    }

    "문자열이 barfoothefoobarman이고 단어배열이 foo,bar일때 반환값은 0,9가 나와야 한다" {
        val result = Solution().findSubstring("barfoothefoobarman", arrayOf("foo", "bar"))

        result shouldContain 0
        result shouldContain 9
    }

    "문자열이 wordgoodgoodgoodbestword이고 단어 배열이 word, good, best, word일때 반환값은 비어있어야 한다" {
        val result = Solution().findSubstring("wordgoodgoodgoodbestword", arrayOf("word", "good", "best", "word"))

        result shouldHaveSize 0
    }

    "문자열이 barfoofoobarthefoobarman이고 단어 배열이 bar, foo, the일때 반환값이 6,9,12가 나와야 한다" {
        val result = Solution().findSubstring("barfoofoobarthefoobarman", arrayOf("bar", "foo", "the"))

        result shouldContain 6
        result shouldContain 9
        result shouldContain 12
    }
})

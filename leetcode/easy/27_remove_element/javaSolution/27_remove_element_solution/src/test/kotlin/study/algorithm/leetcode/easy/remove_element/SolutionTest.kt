package study.algorithm.leetcode.easy.remove_element

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.shouldBe
import kotlin.test.Test
import kotlin.test.assertNotNull

class SolutionTest: StringSpec( {
    "솔루션 테스트" {
        shouldNotThrow<Exception> {
            Solution()
        }
    }

    "배열로 [3,2,2,3]이 주어지고 3이 주어지면 2를 반환하고 배열은 [2,2,_,_] 형태로 바뀌어야 한다" {
        val nums = intArrayOf(3, 2, 2, 3)
        val result = Solution().removeElement(nums, 3)

        result shouldBe 2
        nums.slice(0..result) shouldNotContain 3
    }

    "배열로 [0,1,2,2,3,0,4,2]이 주어지고 2이 주어지면 5를 반환하고 배열은 [0,1,4,0,3,_,_,_] 형태로 바뀌어야 한다" {
        val nums = intArrayOf(0,1,2,2,3,0,4,2)
        val result = Solution().removeElement(nums, 2)

        result shouldBe 5
        nums.slice(0..result) shouldNotContain 2
    }
})

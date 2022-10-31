package study.algorithm.leetcode.medium.swap_nodes_in_pairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun testCase1Test() {
        val solution = Solution()

        val answer = solution.swapPairs(listToListNode(1, 2, 3, 4))

        assertListNodeEquals(listToListNode(2, 1, 4, 3), answer)
    }

    @Test
    fun testCase2Test() {
        val solution = Solution()

        val answer = solution.swapPairs(listToListNode(1))

        assertListNodeEquals(listToListNode(1), answer)
    }

    private fun listToListNode(vararg args: Int): ListNode? =
        if (args.isEmpty()) {
            null
        } else {
            val listNode = ListNode(args[0])
            var pointer = listNode
            for (i in 1 until args.size) {
                pointer.next = ListNode(args[i])
                pointer = pointer.next!!
            }
            listNode
        }

    private fun assertListNodeEquals(expect: ListNode?, actual: ListNode?) {
        var expectPointer = expect
        var actualPointer = actual

        while (expectPointer != null && actualPointer != null) {
            assertEquals(expectPointer.`val`, actualPointer.`val`)
            expectPointer = expectPointer.next
            actualPointer = actualPointer.next
        }

        assertNull(expectPointer)
        assertNull(actualPointer)
    }
}
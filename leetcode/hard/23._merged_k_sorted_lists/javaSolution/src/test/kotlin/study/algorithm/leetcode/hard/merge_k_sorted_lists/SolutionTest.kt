package study.algorithm.leetcode.hard.merge_k_sorted_lists

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

internal class SolutionTest {
    @Test
    fun testCase1Test() {
        val solution = Solution()
        val req = listOf(listToListNode(1, 4, 5), listToListNode(1, 3, 4), listToListNode(2, 6))

        val answer = solution.mergeKLists(req.toTypedArray())

        val expected = listToListNode(1, 1, 2, 3, 4, 4, 5, 6)
        assertListNodeEquals(expected, answer)
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

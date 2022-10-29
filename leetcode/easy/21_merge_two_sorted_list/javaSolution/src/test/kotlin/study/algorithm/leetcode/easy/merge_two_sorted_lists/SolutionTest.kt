package study.algorithm.leetcode.easy.merge_two_sorted_lists

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

internal class SolutionTest {

    @Test
    fun testCase1Test() {
        val solution = Solution()
        val list1 = listToListNode(1, 2, 4)
        val list2 = listToListNode(1, 3, 4)

        val answer = solution.mergeTwoLists(list1, list2)

        val expect = listToListNode(1, 1, 2, 3, 4, 4)

        assertListNodeEquals(expect, answer)
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
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

internal class SolutionTest {

    @Test
    fun simpleSolutionTest() {
        val solution = Solution()

        val fixture = sample01()
        val listNode = fixture[0]
        val answer = solution.removeNthFromEnd(listNode, 2)

        val expect = fixture[1]
        assertListNodes(expect, answer)
    }

    private fun assertListNodes(expect: ListNode?, actual: ListNode?) {
        var pointer = actual
        var expectPointer: ListNode? = expect
        while (pointer != null) {
            assertNotNull(expectPointer)
            assertEquals(expectPointer.`val`, pointer.`val`)
            pointer = pointer.next
            expectPointer = expectPointer.next
        }
    }

    fun sample01(): List<ListNode> {
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        val answer1 = ListNode(1)
        val answer2 = ListNode(2)
        val answer3 = ListNode(3)
        val answer5 = ListNode(5)
        answer1.next = answer2
        answer2.next = answer3
        answer3.next = answer5

        return listOf(node1, answer1)
    }
}

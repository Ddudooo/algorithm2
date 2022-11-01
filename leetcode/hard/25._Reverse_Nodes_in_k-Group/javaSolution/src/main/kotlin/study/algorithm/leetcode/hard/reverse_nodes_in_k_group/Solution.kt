package study.algorithm.leetcode.hard.reverse_nodes_in_k_group

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var temp = head
        for (i in 0 until k) {
            if (temp == null) return head else temp = temp.next
        }
        val newNextStart = reverseKGroup(temp, k)
        var prev: ListNode? = null
        var curr: ListNode? = head
        for (i in 0 until k) {
            val next = curr!!.next
            curr.next = prev

            prev = curr
            curr = next
        }
        head!!.next = newNextStart

        return prev
    }
}
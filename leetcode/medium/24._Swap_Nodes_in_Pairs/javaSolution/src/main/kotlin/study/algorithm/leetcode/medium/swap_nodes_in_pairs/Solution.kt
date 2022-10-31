package study.algorithm.leetcode.medium.swap_nodes_in_pairs

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        head ?: return null

        var pointer: ListNode? = head
        pointer?.next ?: return head
        var cnt = 0

        while (pointer != null) {
            if (cnt % 2 == 0 && pointer.next != null) {
                val originVal = pointer.`val`
                pointer.`val` = pointer.next!!.`val`
                pointer.next!!.`val` = originVal
            }
            pointer = pointer.next
            cnt++
        }

        return head
    }
}
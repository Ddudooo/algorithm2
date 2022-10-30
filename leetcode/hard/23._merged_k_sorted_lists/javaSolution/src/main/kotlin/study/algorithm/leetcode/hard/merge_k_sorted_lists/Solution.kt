package study.algorithm.leetcode.hard.merge_k_sorted_lists

import java.lang.Integer.min

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        lateinit var result: ListNode
        var returnValue: ListNode? = null

        while (!isEmptyListNode(lists)) {
            val (minIdx, minValue) = getMinValueNode(lists)
            if (returnValue == null) {
                result = ListNode(minValue)
                returnValue = result
            } else {
                result.next = ListNode(minValue)
                result = result.next!!
            }
            lists[minIdx] = lists[minIdx]!!.next
        }

        return returnValue;
    }

    private fun getMinValueNode(lists: Array<ListNode?>): Pair<Int, Int> {
        var minIdx = 0
        var minValue = Int.MAX_VALUE
        for ((index, node) in lists.withIndex()) {
            if (node != null) {
                if (min(node.`val`, minValue) < minValue) {
                    minIdx = index
                    minValue = node.`val`
                }
            }
        }
        return Pair(minIdx, minValue)
    }

    private fun isEmptyListNode(lists: Array<ListNode?>): Boolean {
        for (node in lists) {
            if (node != null) {
                return false
            }
        }
        return true
    }
}
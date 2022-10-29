package study.algorithm.leetcode.easy.merge_two_sorted_lists

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        return listToListNode(mergeList(list1, list2).sorted())
    }

    private fun listNodeToList(listNode: ListNode?): List<Int> {
        val result = mutableListOf<Int>()
        var pointer = listNode
        while (pointer != null) {
            result.add(pointer.`val`)
            pointer = pointer.next
        }

        return result
    }

    private fun listToListNode(list: List<Int>): ListNode? =
        if (list.isEmpty()) {
            null
        } else {
            val result = ListNode(list[0])
            var pointer = result;
            for (i in 1 until list.size) {
                pointer.next = ListNode(list[i])
                pointer = pointer.next!!
            }
            result
        }

    private fun mergeList(list1: ListNode?, list2: ListNode?): List<Int> = listNodeToList(list1) + listNodeToList(list2)
}
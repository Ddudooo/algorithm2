class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val values = mutableListOf<Int>()

        var pointer = head
        while (pointer != null) {
            values.add(pointer.`val`)
            pointer = pointer.next
        }

        return listToListNode(values, n)
    }

    private fun listToListNode(list: MutableList<Int>, removeIdx: Int): ListNode? {
        val reversed = list.reversed().toMutableList()

        if (reversed.size >= removeIdx)
            reversed.removeAt(removeIdx - 1)
        val removeList = reversed.reversed()
        if (removeList.isEmpty()) {
            return null
        }

        val node = ListNode(removeList[0])
        var pointer = node

        for ((index, nodeValue) in removeList.withIndex()) {
            if (index == 0) {

                continue
            }

            pointer.next = ListNode(nodeValue)
            pointer = pointer.next!!
        }

        return node
    }
}

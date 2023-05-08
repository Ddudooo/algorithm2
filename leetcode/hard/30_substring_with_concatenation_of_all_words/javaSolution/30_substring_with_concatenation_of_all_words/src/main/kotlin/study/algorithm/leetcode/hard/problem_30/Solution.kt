package study.algorithm.leetcode.hard.problem_30

class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val count = words[0].length
        var left = 0
        var right = (words.size * count)
        val result = mutableListOf<Int>()

        while(right <= s.length) {
            val combination = s.substring(left, right).chunked(count).toMutableList()

            if(isInclude(words, combination)) {
                result.add(left)
            }
            left++
            right++
        }

        return result
    }

    private fun isInclude(words: Array<String>, combination: MutableList<String>): Boolean {
        for (word in words) {
            if (!combination.contains(word)) {
                return false
            } else {
                combination.remove(word)
            }
        }
        return true
    }
}

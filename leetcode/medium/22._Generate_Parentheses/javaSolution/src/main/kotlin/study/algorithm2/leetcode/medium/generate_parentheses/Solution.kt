package study.algorithm2.leetcode.medium.generate_parentheses

private const val OPEN_PARENT = "("
private const val CLOSE_PARENT = ")"

class Solution {

    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()

        generate("", 0, 0, n, result)
        return result
    }

    private fun generate(initStr: String, open: Int, close: Int, n: Int, list: MutableList<String>) {
        if (open == n && close == n) {
        
            list.add(initStr)
        }

        if (close > open) {

            return
        }

        if (open > n || close > n) {

            return
        }


        generate("$initStr$OPEN_PARENT", open + 1, close, n, list)


        generate("$initStr$CLOSE_PARENT", open, close + 1, n, list)

    }
}
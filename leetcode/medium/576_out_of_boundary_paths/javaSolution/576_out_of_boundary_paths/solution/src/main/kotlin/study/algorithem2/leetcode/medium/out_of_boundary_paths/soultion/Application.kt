package study.algorithem2.leetcode.medium.out_of_boundary_paths.soultion

import java.math.BigInteger

class Application {

    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        if (maxMove == 0) return 0;
        val dp = Array(m) { Array(n) { Array(maxMove+1) {0.toBigInteger()} } }

        return (solution(m, n, maxMove, startRow, startColumn, 0, dp) % (1000000007).toBigInteger()).toInt()
    }

    private fun solution(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int, currentMove: Int,dp :Array<Array<Array<BigInteger>>>): BigInteger{
        if(currentMove > maxMove) return BigInteger.ZERO

        if(startRow< 0|| startColumn < 0 || startRow >= m || startColumn >= n) return BigInteger.ONE

        if(dp[startRow][startColumn][currentMove] != BigInteger.ZERO) return dp[startRow][startColumn][currentMove]

        val up = solution(m, n, maxMove, startRow - 1, startColumn, currentMove + 1, dp)
        val down = solution(m, n, maxMove, startRow + 1, startColumn, currentMove + 1, dp)
        val left = solution(m, n, maxMove, startRow, startColumn - 1, currentMove + 1, dp)
        val right = solution(m, n, maxMove, startRow, startColumn + 1, currentMove + 1, dp)

        val value = (up + down + left + right)
        dp[startRow][startColumn][currentMove] = value
        return dp[startRow][startColumn][currentMove]
    }
}

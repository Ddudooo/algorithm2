package study.algorithem2.leetcode.medium.out_of_boundary_paths.soultion

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun test() {
        val application = Application()
        val result = application.findPaths(8, 50, 23, 5, 26)

        assertEquals(914783380, result)
    }
}

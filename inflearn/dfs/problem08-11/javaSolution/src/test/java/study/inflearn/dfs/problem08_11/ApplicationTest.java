package study.inflearn.dfs.problem08_11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem08_11_params")
	void solutionTest(String inputStr, int expect) {
		Application app = new Application();

		int answer = app.solution(strToBooleanMatrix(inputStr, 7, 7));

		assertEquals(expect, answer);
	}

	private boolean[][] strToBooleanMatrix(String input, int x, int y) {
		boolean[][] map = new boolean[x][y];
		String[] split = input.trim().split("\n");
		for (int i = 0; i < x; i++) {
			String[] elements = split[i].trim().split(" ");
			for (int j = 0; j < y; j++) {
				map[i][j] = Integer.parseInt(elements[j]) == 1;
			}
		}
		return map;
	}

	private static Stream<Arguments> problem08_11_params() {
		return Stream.of(
			of("0 0 0 0 0 0 0\n"
				+ "0 1 1 1 1 1 0\n"
				+ "0 0 0 1 0 0 0\n"
				+ "1 1 0 1 0 1 1\n"
				+ "1 1 0 0 0 0 1\n"
				+ "1 1 0 1 1 1 0\n"
				+ "1 0 0 0 0 0 0", 12),
			of("0 0 0 0 0 0 0\n"
				+ "0 1 1 1 1 0 0\n"
				+ "0 0 1 1 0 0 1\n"
				+ "1 1 0 0 0 1 0\n"
				+ "1 1 0 0 0 0 0\n"
				+ "1 1 0 0 1 0 0\n"
				+ "1 0 1 0 0 0 0", 14),
			of("0 0 0 0 0 0 0\n"
				+ "0 1 1 0 1 1 0\n"
				+ "0 0 0 1 0 1 0\n"
				+ "1 1 0 1 1 0 1\n"
				+ "1 1 1 0 1 0 1\n"
				+ "1 1 1 0 1 0 0\n"
				+ "1 0 1 0 0 0 0", -1),
			of("0 0 0 0 0 0 0\n"
				+ "0 1 1 1 1 1 0\n"
				+ "0 0 1 0 0 0 0\n"
				+ "1 0 1 0 1 1 1\n"
				+ "1 1 1 0 0 0 1\n"
				+ "1 1 1 1 1 0 0\n"
				+ "1 0 1 0 0 0 0", 18),
			of("0 0 0 0 1 0 0\n"
				+ "0 1 1 0 1 1 0\n"
				+ "0 0 1 0 0 0 1\n"
				+ "1 0 0 0 0 1 0\n"
				+ "1 0 0 0 1 0 0\n"
				+ "1 1 1 1 1 1 0\n"
				+ "1 0 0 0 0 0 0", -1)
		);
	}
}
package study.inflearn.dfs.problem08_13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem08_13_params")
	void solutionTest(String inputStr, int expect) {
		Application app = new Application();
		String[] split = inputStr.trim().split("\n");
		int n = Integer.parseInt(split[0]);
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(split[i + 1].trim().split(" ")).mapToInt(Integer::parseInt)
				.toArray();
		}

		int answer = app.solution(n, map);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem08_13_params() {
		return Stream.of(
			of("5\n"
				+ "0 0 0 0 0\n"
				+ "1 0 0 1 1\n"
				+ "0 1 0 1 0\n"
				+ "1 1 0 1 0\n"
				+ "1 1 0 0 0", 2),
			of("10\n"
				+ "0 0 0 0 1 0 0 1 1 1\n"
				+ "0 1 0 0 1 0 0 0 1 0\n"
				+ "1 0 1 0 0 0 0 0 0 1\n"
				+ "0 1 1 0 0 0 1 0 0 1\n"
				+ "1 0 1 1 1 0 0 0 1 1\n"
				+ "0 0 0 0 1 0 0 1 1 1\n"
				+ "0 0 1 1 1 0 0 0 0 0\n"
				+ "0 1 0 0 1 0 0 0 0 0\n"
				+ "1 0 0 0 0 1 1 0 1 0\n"
				+ "1 0 0 0 1 1 1 0 0 1", 5),
			of("15\n"
				+ "0 0 0 0 0 0 0 1 0 0 0 1 0 1 0\n"
				+ "0 0 0 0 0 0 1 0 0 0 0 0 0 0 0\n"
				+ "0 0 0 0 1 1 0 0 0 1 0 0 0 0 0\n"
				+ "0 0 0 1 0 1 0 0 0 0 0 1 0 0 0\n"
				+ "1 1 0 1 0 0 0 0 0 0 0 0 0 0 0\n"
				+ "0 0 0 0 0 0 0 0 0 0 0 0 0 0 1\n"
				+ "0 0 0 1 0 1 0 0 0 0 0 0 0 0 1\n"
				+ "0 1 0 1 0 1 1 0 0 0 1 0 0 0 0\n"
				+ "0 0 0 0 0 1 1 0 1 0 0 0 0 0 0\n"
				+ "0 0 0 0 1 0 0 1 0 0 0 0 0 0 0\n"
				+ "0 0 0 0 0 0 0 0 0 0 0 0 0 1 0\n"
				+ "0 0 0 0 0 0 1 0 0 1 1 0 0 0 0\n"
				+ "0 0 0 0 0 1 0 0 0 0 0 1 0 0 0\n"
				+ "1 1 1 1 0 0 1 0 0 0 1 0 1 0 1\n"
				+ "1 0 0 0 1 0 0 1 1 0 0 1 0 0 0", 16),
			of("20\n"
				+ "1 1 0 0 1 0 0 1 1 0 0 0 1 0 0 1 0 0 1 0\n"
				+ "0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 1\n"
				+ "0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 1 0 0 1\n"
				+ "0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0\n"
				+ "0 1 0 0 0 1 0 1 0 1 0 0 0 1 0 0 0 0 1 0\n"
				+ "0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0\n"
				+ "0 0 0 1 1 0 0 0 0 1 0 0 1 0 0 0 0 1 0 0\n"
				+ "0 1 0 1 1 0 0 0 0 0 0 0 0 0 0 0 1 0 1 1\n"
				+ "0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 1 0\n"
				+ "0 0 0 0 0 1 0 1 0 1 0 0 1 1 1 0 0 0 1 0\n"
				+ "0 0 1 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 1\n"
				+ "0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 1 1\n"
				+ "1 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0\n"
				+ "0 0 1 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0\n"
				+ "0 0 0 0 1 1 0 1 0 1 0 0 1 0 0 0 0 0 0 0\n"
				+ "0 0 0 0 0 0 0 0 0 0 0 1 1 1 0 0 1 0 0 0\n"
				+ "0 1 1 0 1 0 1 0 0 0 0 0 1 0 0 1 0 0 0 1\n"
				+ "0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0\n"
				+ "0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 0\n"
				+ "1 1 0 0 0 0 0 0 0 0 0 0 0 1 0 1 1 0 0 1", 37),
			of("20\n"
				+ "0 0 0 0 0 0 0 1 1 0 0 0 0 0 0 0 1 0 0 1\n"
				+ "0 1 0 0 0 1 0 0 0 0 0 0 0 0 1 0 0 1 0 0\n"
				+ "0 0 0 0 1 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0\n"
				+ "0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 1 0\n"
				+ "1 1 0 0 1 1 0 0 1 1 0 1 1 0 0 1 0 0 1 1\n"
				+ "0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 0\n"
				+ "0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 1 0\n"
				+ "0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0\n"
				+ "0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
				+ "1 0 1 0 0 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0\n"
				+ "0 1 0 0 0 0 1 0 0 0 0 0 0 1 0 1 0 0 1 0\n"
				+ "0 0 0 1 0 0 0 0 0 0 1 0 0 0 0 1 1 0 0 1\n"
				+ "0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0\n"
				+ "0 0 0 0 0 1 0 0 0 0 1 0 0 0 0 0 1 1 0 0\n"
				+ "0 0 0 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0\n"
				+ "0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 1 0 0 0 0\n"
				+ "0 1 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 0 1 0\n"
				+ "1 0 1 0 0 0 0 1 0 0 0 1 0 0 0 0 0 0 1 0\n"
				+ "0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0\n"
				+ "0 1 1 0 1 1 0 0 0 1 0 0 0 0 0 0 0 1 0 0", 38)
		);
	}
}
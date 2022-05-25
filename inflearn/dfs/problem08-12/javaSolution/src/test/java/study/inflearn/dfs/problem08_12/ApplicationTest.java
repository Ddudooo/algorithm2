package study.inflearn.dfs.problem08_12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem08_12_params")
	void solutionTest(String inputStr, int expect) {
		Application app = new Application();
		String[] split = inputStr.trim().split("\n");
		int[] conditions = Arrays.stream(split[0].trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int x = conditions[0];
		int y = conditions[1];
		int[][] map = strToMatrix(split, x, y);
		int answer = app.solution(x, y, map);

		assertEquals(expect, answer);
	}

	private int[][] strToMatrix(String[] inputStr, int x, int y) {
		int[][] map = new int[x][y];
		for (int i = 0; i < x; i++) {
			int[] split = Arrays.stream(inputStr[i + 1].trim().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			for (int j = 0; j < y; j++) {
				map[i][j] = split[j];
			}
		}
		return map;
	}

	private static Stream<Arguments> problem08_12_params() {
		return Stream.of(
			of("10 10\n"
				+ "0 -1 0 -1 1 -1 0 0 0 0 \n"
				+ "0 0 0 0 0 0 0 1 0 0 \n"
				+ "0 0 0 0 0 0 0 -1 0 -1 \n"
				+ "1 0 0 0 -1 0 1 -1 0 0 \n"
				+ "0 0 0 0 0 -1 0 0 0 0 \n"
				+ "0 1 0 1 0 0 1 0 0 0 \n"
				+ "0 0 0 1 0 0 0 0 0 0 \n"
				+ "0 0 -1 0 0 0 0 0 -1 0 \n"
				+ "-1 0 0 0 -1 0 0 0 0 0 \n"
				+ "0 0 -1 0 0 0 0 1 0 0", 5),
			of("50 50\n"
					+ "0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 0 0 0 1 0 -1 0 0 -1 0 0 0 0 0 1 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1 \n"
					+ "0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 \n"
					+ "-1 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 -1 0 0 0 0 0 0 0 1 0 0 0 0 0 \n"
					+ "0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 0 0 \n"
					+ "0 0 0 0 -1 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 -1 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 \n"
					+ "0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 1 0 -1 0 0 0 0 -1 0 0 0 0 0 0 -1 0 0 0 0 -1 0 0 0 0 0 0 0 -1 0 0 0 0 0 1 0 \n"
					+ "0 0 1 0 0 0 0 0 -1 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 -1 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 \n"
					+ "0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 1 0 0 0 -1 0 0 0 0 0 0 0 0 \n"
					+ "0 -1 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 -1 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 \n"
					+ "0 1 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 -1 0 0 0 0 0 1 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 1 \n"
					+ "0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 -1 0 0 0 \n"
					+ "0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 \n"
					+ "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 -1 0 \n"
					+ "1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 \n"
					+ "0 0 -1 0 0 -1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 -1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 -1 0 0 1 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 1 1 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 \n"
					+ "0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 -1 1 0 0 -1 0 \n"
					+ "0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 -1 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 0 -1 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 -1 0 -1 0 0 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 0 -1 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 1 0 0 -1 0 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 0 1 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 \n"
					+ "0 0 0 0 0 0 1 1 0 1 0 -1 0 0 0 0 0 0 -1 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 1 0 1 -1 0 0 0 0 \n"
					+ "0 0 0 0 1 0 0 0 0 0 0 0 0 1 0 0 -1 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 \n"
					+ "-1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 -1 0 0 0 0 0 1 0 0 0 0 0 0 0 -1 0 -1 0 0 0 0 -1 1 0 \n"
					+ "0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 -1 0 0 0 0 0 0 0 0 -1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 \n"
					+ "0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 -1 0 0 0 1 0 \n"
					+ "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 -1 -1 0 0 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 1 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 \n"
					+ "0 0 0 0 0 1 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 \n"
					+ "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 -1 0 \n"
					+ "0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 -1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 \n"
					+ "0 0 1 0 0 0 0 0 1 0 0 0 -1 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 -1 0 0 0 0 0 1 \n"
					+ "0 0 0 0 0 -1 1 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 -1 0 0 0 0 0 0 0 1 1 -1 0 \n"
					+ "0 0 0 -1 0 0 -1 0 0 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 1 0 0 0 0 \n"
					+ "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 \n"
					+ "0 0 0 0 0 0 0 0 0 0 1 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 \n"
					+ "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 -1 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 -1 0 0 0 0 0 \n"
					+ "-1 0 0 0 0 -1 0 0 0 0 0 -1 -1 -1 1 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0",
				8)
		);
	}
}
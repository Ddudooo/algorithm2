package study.inflearn.dfs.problem08_10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem08_10_params")
	void solutionTest(String inputStr, int expect) {
		Application app = new Application();

		int answer = app.solution(strToBooleanAry(inputStr));

		assertEquals(expect, answer);
	}

	private boolean[][] strToBooleanAry(String str) {
		String[] split = str.trim().split("\n");
		boolean[][] result = new boolean[8][8];
		for (int i = 0; i < 7; i++) {
			String[] splitLine = split[i].trim().split(" ");
			for (int j = 0; j < 7; j++) {
				boolean value = Integer.parseInt(splitLine[j]) == 1;
				result[i + 1][j + 1] = value;
			}
		}
		return result;
	}

	private static Stream<Arguments> problem08_10_params() {
		return Stream.of(
			of("0 0 0 0 0 0 0\n"
				+ "0 1 1 1 1 1 0\n"
				+ "0 0 0 1 0 0 0\n"
				+ "1 1 0 1 0 1 1\n"
				+ "1 1 0 0 0 0 1\n"
				+ "1 1 0 1 1 1 0\n"
				+ "1 0 0 0 0 0 0", 2),
			of("0 0 0 0 0 0 0\n"
				+ "0 1 1 1 1 1 0\n"
				+ "0 0 0 1 0 0 0\n"
				+ "1 1 0 0 0 1 1\n"
				+ "1 1 0 0 0 0 1\n"
				+ "1 1 0 0 1 0 0\n"
				+ "1 0 1 0 0 0 0", 46),
			of("0 0 0 0 0 0 0\n"
				+ "0 1 1 0 1 1 0\n"
				+ "0 0 0 0 0 0 0\n"
				+ "1 1 0 0 1 1 1\n"
				+ "1 1 1 0 0 0 1\n"
				+ "1 1 1 0 1 0 0\n"
				+ "1 0 1 0 0 0 0", 24),
			of("0 0 0 0 1 0 0\n"
				+ "0 1 1 0 1 1 0\n"
				+ "0 0 1 0 0 0 0\n"
				+ "1 0 0 0 1 1 1\n"
				+ "1 1 1 0 0 0 1\n"
				+ "1 1 1 0 1 0 0\n"
				+ "1 0 1 0 0 0 0", 8),
			of("0 0 0 0 1 0 0\n"
				+ "0 1 1 0 1 1 0\n"
				+ "0 0 1 0 0 0 0\n"
				+ "1 0 0 0 0 1 1\n"
				+ "1 1 1 0 0 0 0\n"
				+ "1 1 1 0 1 1 0\n"
				+ "1 0 1 0 0 0 0", 14)
		);
	}
}
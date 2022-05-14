package study.inflearn.dfs.problem08_01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem08_01_params")
	void solutionTest(String inputStr, String expectStr) {
		Application app = new Application();
		String[] split = inputStr.trim().split("\n");
		int[] input = Arrays.stream(split[1].trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();

		boolean answer = app.solution(input);
		boolean expect = "YES".equalsIgnoreCase(expectStr);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem08_01_params() {
		return Stream.of(
			of("6\n"
				+ "2 4 5 10 12 13", "YES"),
			of("7\n"
				+ "1 2 3 4 5 6 7", "YES"),
			of("9\n"
				+ "3 6 1 4 7 16 34 23 12", "YES"),
			of("9\n"
				+ "3 6 13 11 7 16 34 23 12", "NO"),
			of("10\n"
				+ "3 6 9 13 11 7 16 34 23 12", "YES")
		);
	}
}
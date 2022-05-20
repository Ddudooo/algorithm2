package study.inflearn.dfs.problem08_08;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem08_08_params")
	void solutionTest(String inputStr, String expectStr) {
		Application app = new Application();
		int[] inputs = strToIntAry(inputStr, " ");

		int[] answer = app.solution(inputs[0], inputs[1]);
		int[] expectAry = strToIntAry(expectStr, " ");

		assertArrayEquals(expectAry, answer);
	}

	private int[] strToIntAry(String input, String delimiter) {
		return Arrays.stream(input.trim().split(delimiter)).mapToInt(Integer::parseInt).toArray();
	}

	private static Stream<Arguments> problem08_08_params() {
		return Stream.of(
			of("5 39", "4 1 3 2 5"),
			of("9 1610", "1 2 3 5 9 6 8 4 7"),
			of("9 730", "7 6 4 2 1 3 5 8 9"),
			of("7 288", "1 2 4 5 6 3 7"),
			of("10 2196", "1 6 9 4 2 3 5 10 7 8")
		);

	}
}
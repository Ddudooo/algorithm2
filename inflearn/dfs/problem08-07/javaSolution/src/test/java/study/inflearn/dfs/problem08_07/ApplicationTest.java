package study.inflearn.dfs.problem08_07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem08_07_params")
	void solutionTest(String inputStr, int expect) {
		Application app = new Application();
		int[] inputs = Arrays.stream(inputStr.trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();

		int answer = app.solution(inputs[0], inputs[1]);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem08_07_params() {
		return Stream.of(
			of("5 3", 10),
			of("9 3", 84),
			of("15 7", 6435),
			of("19 11", 75582),
			of("20 11", 167960)
		);
	}
}
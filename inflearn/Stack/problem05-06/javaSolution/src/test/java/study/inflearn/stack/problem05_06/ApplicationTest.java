package study.inflearn.stack.problem05_06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem05_06_params")
	void solutionTest(String inputStr, int expect) {
		Application app = new Application();
		int[] inputs = Arrays.stream(inputStr.trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int answer = app.solution(inputs[0], inputs[1]);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem05_06_params() {
		return Stream.of(
			of("20 3", 20),
			of("100 3", 91),
			of("500 8", 494),
			of("700 9", 212),
			of("1000 9", 329)
		);
	}
}
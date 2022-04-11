package study.inflearn.array.problem02_07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem02_07_params")
	void solutionTest(String input, int expect) {
		Application app = new Application();
		int[] inputs = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
		int answer = app.solution(inputs);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem02_07_params() {
		return Stream.of(
			Arguments.of("1 0 1 1 1 0 0 1 1 0", 10),
			Arguments.of("0 1 0 0 1 0 1 1 0 0", 5),
			Arguments.of("0 0 0 0 0 0 1 0 0 1 0 0 0 1 0 0 0 1 1 1", 9),
			Arguments.of("1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1", 465),
			Arguments.of(
				"1 1 1 0 0 1 0 1 1 0 0 0 0 0 0 1 0 1 1 1 1 1 0 1 1 0 0 0 0 1 1 1 1 0 0 0 1 0 0 1",
				41),
			Arguments.of(
				"0 0 1 1 1 0 1 1 1 1 1 1 0 1 0 1 0 1 1 0 0 1 1 0 1 0 1 1 1 0 1 1 1 1 1 1 0 0 0 0 0 0 0 1 0 1 1 1 1 0 1 1 0 0 0 0 0 1 0 1 1 0 1 0 1 1 1 1 1 0 0 0 1 1 1 0 1 0 1 1 0 1 1 0 1 0 0 1 0 1 1 0 1 1 0 1 0 0 1 1",
				122)
		);
	}

}
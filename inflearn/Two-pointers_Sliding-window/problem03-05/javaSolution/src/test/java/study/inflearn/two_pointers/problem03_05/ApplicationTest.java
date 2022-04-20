package study.inflearn.two_pointers.problem03_05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem03_05_params")
	void solutionTest(int input, int expect) {
		Application app = new Application();

		int answer = app.solution(input);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem03_05_params() {
		return Stream.of(
			Arguments.of(12, 1),
			Arguments.of(19, 1),
			Arguments.of(120, 3),
			Arguments.of(720, 5),
			Arguments.of(450, 8)
		);
	}
}
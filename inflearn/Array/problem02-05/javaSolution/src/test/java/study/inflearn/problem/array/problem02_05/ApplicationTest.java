package study.inflearn.problem.array.problem02_05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem_02_05_params")
	void solutionTest(int n, int expect) {
		Application app = new Application();

		int answer = app.solution(n);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem_02_05_params() {
		return Stream.of(
			Arguments.of(20, 8),
			Arguments.of(200000, 17984),
			Arguments.of(100000, 9592)
		);
	}
}
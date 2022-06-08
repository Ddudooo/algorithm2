package study.inflearn.dp.problem10_02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem10_02_params")
	void solutionTest(int n, int expect) {
		Application app = new Application();

		int answer = app.solution(n);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem10_02_params() {
		return Stream.of(
			of(7, 34),
			of(12, 377),
			of(33, 9227465),
			of(30, 2178309),
			of(24, 121393)
		);
	}
}
package study.inflearn.dp.problem10_01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem10_01_params")
	void solutionTest(int n, int expect) {
		Application app = new Application();

		int answer = app.solution(n);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem10_01_params() {
		return Stream.of(
			of(7, 21),
			of(12, 233),
			of(33, 5702887),
			of(30, 1346269),
			of(24, 75025)
		);
	}
}
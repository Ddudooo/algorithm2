package study.inflearn.stack.problem05_04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem05_04_params")
	void solutionTest(String input, int expect) {
		Application app = new Application();

		int answer = app.solution(input);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem05_04_params() {
		return Stream.of(
			of("35+2*", 16),
			of("352+*9-", 12),
			of("573*+5-323*++", 30),
			of("58+65*+32+-73*-5-323*++", 21),
			of("58+65*+32+-73*-5-323*++53+2+52*-+3+", 24)
		);
	}
}
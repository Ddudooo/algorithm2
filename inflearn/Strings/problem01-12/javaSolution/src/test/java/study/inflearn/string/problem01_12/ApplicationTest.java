package study.inflearn.string.problem01_12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem01_12_params")
	void solutionTest(String input, String expect) {
		Application app = new Application();

		String answer = app.solution(input);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem01_12_params() {
		return Stream.of(
			Arguments.of("#****###**#####**#####**##**", "COOL")
		);
	}
}
package study.inflearn.stack.problem05_01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem05_01_params")
	void solutionTest(String input, boolean expect) {
		Application app = new Application();

		boolean answer = app.solution(input);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem05_01_params() {
		return Stream.of(
			of("(())()", true),
			of("((()())())))", false),
			of(")(())(", false),
			of("((())())())(", false),
			of("(((())((((())((((())))))))))", true)
		);
	}
}
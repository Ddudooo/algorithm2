package study.inflearn.stack.problem05_05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem05_05_params")
	void solutionTest(String input, int expect) {
		Application app = new Application();

		int answer = app.solution(input);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem05_05_params() {
		return Stream.of(
			of("()(((()())(())()))(())", 17),
			of("(((()(()()))(())()))(()())", 24),
			of("(((()(()()))(())()))(()())(((()(()()))(())()))(()())", 48),
			of("(((()(()()))(())()))(()())(((()(()()))(())()))(()())(((()())))", 57),
			of("(((()(()()))(())()))(()())(((()(()()))(())()))(()())(((()())))(((()(()()))(())()))(()())(((()(()()))(())()))(()())(((()())))(((()(()()))(())()))(()())(((()(()()))(())()))(()())(((()())))(((()(()()))(())()))(()())(((()(()()))(())()))(()())(((()())))(((()(()()))(())()))(()())(((()(()()))(())()))(()())(((()())))(((()(()()))(())()))(()())(((()(()()))(())()))(()())(((()())))",
				342)
		);
	}
}
package study.inflearn.string.problem01_09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem01_09_params")
	void solutionTest(String input, int expect) {
		Application app = new Application();

		int answer = app.solution(input);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem01_09_params() {
		return Stream.of(
			Arguments.of("g0en2T0s8eSoft", 208),
			Arguments.of("kdk1k0kdjfkj0kkdjkfj0fkd", 1000),
			Arguments.of("dkf0jkk0dkjkgjljl1kgh0ekjlkjf2lkjsklfjlkdj", 102),
			Arguments.of("Akdj0Gk1djADG2SDGkdj0f", 120),
			Arguments.of("Akdj0Gk1dgdgdAGSGAG3DGGA45GAGADGDGdjADG2SDGkdj0f", 134520)
		);
	}
}
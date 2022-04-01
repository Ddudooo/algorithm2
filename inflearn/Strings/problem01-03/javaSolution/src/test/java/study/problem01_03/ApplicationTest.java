package study.problem01_03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem01_03_params")
	void parameterizeTest(String input, String expect) {
		String answer = Application.solution(input);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem01_03_params() {
		return Stream.of(
			Arguments.of("it is time to study", "study")
		);
	}
}
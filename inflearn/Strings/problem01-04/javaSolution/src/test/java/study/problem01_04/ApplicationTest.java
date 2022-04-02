package study.problem01_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem01_04_params")
	void solution(String reverse, String expect) {
		String answer = Application.reverseWord(reverse);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem01_04_params() {
		return Stream.of(
			Arguments.of("good", "doog"),
			Arguments.of("Time", "emiT"),
			Arguments.of("Big", "giB")
		);
	}
}
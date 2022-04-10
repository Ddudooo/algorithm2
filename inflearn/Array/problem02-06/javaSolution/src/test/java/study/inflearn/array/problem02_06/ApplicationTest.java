package study.inflearn.array.problem02_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("reverseTest_params")
	void reverseTest(String input, int expect) {
		Application app = new Application();

		int answer = app.stringToReverseNumber(input);

		assertEquals(expect, answer);
	}

	@ParameterizedTest
	@MethodSource("isPrimeTest_params")
	void isPrimeTest(int number, boolean expect) {
		Application app = new Application();

		boolean answer = app.isPrimeNumber(number);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> reverseTest_params() {
		return Stream.of(
			Arguments.of("32", 23),
			Arguments.of("55", 55),
			Arguments.of("62", 26),
			Arguments.of("20", 2),
			Arguments.of("250", 52),
			Arguments.of("370", 73),
			Arguments.of("200", 2)
		);
	}

	private static Stream<Arguments> isPrimeTest_params() {
		return Stream.of(
			Arguments.of(23, true),
			Arguments.of(55, false),
			Arguments.of(26, false),
			Arguments.of(2, true),
			Arguments.of(3, true),
			Arguments.of(52, false),
			Arguments.of(73, true)
		);
	}
}
package study.inflearn.stack.problem05_07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem05_07_params")
	void solutionTest(String inputStrs, String expectStr) {
		Application app = new Application();
		String[] splitInputs = inputStrs.trim().split("\n");

		boolean answer = app.solution(splitInputs[0], splitInputs[1]);
		boolean expect = "YES".equalsIgnoreCase(expectStr);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem05_07_params() {
		return Stream.of(
			of("CBA\n"
				+ "CBDAGE", "YES"),
			of("AKDEF\n"
				+ "AYKGDHEJ", "NO"),
			of("QWERTY\n"
				+ "AYKGDHEJF", "NO"),
			of("ABCDE\n"
				+ "ABCKSEY", "NO"),
			of("AKSDE\n"
				+ "KSDEYBCEGS", "NO")
		);
	}
}
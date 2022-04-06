package study.inflearn.string.problem01_11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem01_11_params")
	void solutionTest(String input, String expect) {
		Application app = new Application();

		String answer = app.solution(input);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem01_11_params() {
		return Stream.of(
			Arguments.of("KKTFFFFFFEEE", "K2TF6E3"),
			Arguments.of("KDKGKKSKKFJKKKKSLSSSSKFKSSSS", "KDKGK2SK2FJK4SLS4KFKS4"),
			Arguments.of("KKKKKDDDDDKDDDKKSKKFJKKKKSLSSSSKFKSSSS", "K5D5KD3K2SK2FJK4SLS4KFKS4"),
			Arguments.of("KKKKTTTUUUKDDDDDKDDDKKSKKFJKYYYKUYY", "K4T3U3KD5KD3K2SK2FJKY3KUY2"),
			Arguments.of("KSTTTSEEKFKKKDJJGG", "KST3SE2KFK3DJ2G2")
		);
	}
}
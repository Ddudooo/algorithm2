package study.inflearn.hash.problem04_01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem04_01_params")
	void solutionTest(String input, char expect) {
		Application app = new Application();
		String[] splitInputs = input.split("\n");
		char[] inputs = splitInputs[1].trim().toCharArray();
		char answer = app.solution(inputs);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem04_01_params() {
		return Stream.of(
			of(
				"15\n"
					+ "BACBACCACCBDEDE", 'C'
			),
			of("20\n"
				+ "BDDAAAAEDCAACBAAABAC", 'A'),
			of("30\n"
				+ "CECBBBABBBEDBCBAABDABBBABCEAEE", 'B'),
			of("40\n"
				+ "CBDCBCECCCCBADCCCECCBECAECCCDCCABCDADEAC", 'C'),
			of("50\n"
				+ "DDACBBBEABBEABEDCBADDEBBEDABADDBBBBEDDBBBBEBBACCDB", 'B')
		);
	}
}
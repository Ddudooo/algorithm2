package study.inflearn.string.problem01_08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem01_08_params")
	void solutionTest(String input, boolean expect) {
		Application app = new Application();

		boolean answer = app.solution(input);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem01_08_params() {
		return Stream.of(
			Arguments.of("found7, time: study; Yduts; emit, 7Dnuof", true),
			Arguments.of("found7, timk: study; Yduts; emit, 7Dnuof", false),
			Arguments.of("Tae,aba;e#%a*T", true),
			Arguments.of("kdjg$@kjkldjkg%@dkjgkj", false),
			Arguments.of("a sd fg #%hjkl; %#$@! lkj&*hgfd s ##a", true)
		);
	}
}
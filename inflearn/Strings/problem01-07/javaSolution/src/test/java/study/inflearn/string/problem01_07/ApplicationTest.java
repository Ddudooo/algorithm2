package study.inflearn.string.problem01_07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem01_07_params")
	void solutionTest(String input, boolean expect) {
		Application app = new Application();

		boolean answer = app.solution(input);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem01_07_params() {
		return Stream.of(
			Arguments.of("gooG", true),
			Arguments.of("tttttttttttttt", true),
			Arguments.of("sssssssssssssssksssssssssssssss", true),
			Arguments.of("sssssssssssssssksssssssssssssss", true),
			Arguments.of(
				"kstudkgksjlkgjlksjdggkkllllllllllllllllllllllsjgksjldgjlllllllllllllllgjks",
				false),
			Arguments.of("skSKskuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuKSksks",
				true)
		);
	}
}
package study.problem01_03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem01_03_params")
	void parameterizeTest(String input, String expect) {
		Application app = new Application();

		String answer = app.solution(input);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem01_03_params() {
		return Stream.of(
			of("it is time to study", "study"),
			of("dkjg LKKL KJkjglkd Kjgkd LKKJLJLJLKJLLLLLLL", "LKKJLJLJLKJLLLLLLL"),
			of("eitoiw iruow witouweiotwiowioei eiiuow e", "witouweiotwiowioei"),
			of("jddgshsgskjkdj dijglolkdwoig dkjkljglkd gksjlkjgls gkjldkjgla", "jddgshsgskjkdj"),
			of("loveispower", "loveispower")
		);
	}
}
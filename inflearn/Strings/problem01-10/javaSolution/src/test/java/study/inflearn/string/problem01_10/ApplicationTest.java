package study.inflearn.string.problem01_10;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem01_10_params")
	void solutionTest(String input, char t, int[] expect) {
		Application app = new Application();

		int[] answer = app.solution(input, t);

		assertArrayEquals(expect, answer);
	}

	private static Stream<Arguments> problem01_10_params() {
		return Stream.of(
			of("teachermode", 'e', new int[]{1, 0, 1, 2, 1, 0, 1, 2, 2, 1, 0}),
			of("fkdgkjdflkgjljslgjkfldjlkfdg", 'f',
				new int[]{0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 2, 1,
					0, 1, 2}),
			of("kkkkkkkk", 'k', new int[]{0, 0, 0, 0, 0, 0, 0, 0}),
			of("eochjgoekghlakegh", 'h',
				new int[]{3, 2, 1, 0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 3, 2, 1, 0}),
			of("timeout", 't', new int[]{0, 1, 2, 3, 2, 1, 0})
		);
	}
}
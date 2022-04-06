package study.inflearn.array.problem02_01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem02_01_params")
	void solutionTest(int[] input, int[] expect) {
		Application app = new Application();

		int[] answer = app.solution(input);

		assertArrayEquals(expect, answer);
	}

	private static Stream<Arguments> problem02_01_params() {
		return Stream.of(
			Arguments.of(
				new int[]{7, 3, 9, 5, 6, 12},
				new int[]{7, 9, 6, 12}
			),
			Arguments.of(
				new int[]{1, 2, 3},
				new int[]{1, 2, 3}
			),
			Arguments.of(
				new int[]{3, 2, 1},
				new int[]{3}
			),
			Arguments.of(
				new int[]{3, 2, 1, 3, 2, 1, 3},
				new int[]{3, 3, 3}
			),
			Arguments.of(
				new int[]{7, 3, 10, 9, 5, 6, 7, 9, 20, 19, 12, 15},
				new int[]{7, 10, 6, 7, 9, 20, 15}
			),
			Arguments.of(
				new int[]{7, 3, 10, 9, 5, 6, 7, 9, 20, 19, 12, 11, 15, 19},
				new int[]{7, 10, 6, 7, 9, 20, 15, 19}
			)
		);
	}
}
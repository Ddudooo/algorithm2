package study.inflearn.bfs.problem07_08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem07_08_params")
	void solutionTest(String inputStr, int expect) {
		Application app = new Application();
		int[] inputs = Arrays.stream(inputStr.trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();

		int answer = app.solution(inputs[0], inputs[1]);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem07_08_params() {
		return Stream.of(
			of("8 3", 5),
			of("13 35", 6),
			of("1 21", 4),
			of("3 4356", 873),
			of("7 8945", 1790)
		);
	}
}
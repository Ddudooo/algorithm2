package study.inflearn.dfs.problem08_05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem08_05_params")
	void solutionTest(String inputStr, int expect) {
		Application app = new Application();
		String[] sp = inputStr.trim().split("\n");
		int[] inputs = Arrays.stream(sp[1].trim().split(" ")).mapToInt(Integer::parseInt).toArray();
		int m = Integer.parseInt(sp[2].trim());

		int answer = app.solution(inputs, m);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem08_05_params() {
		return Stream.of(
			of("3\n"
				+ "1 2 5\n"
				+ "15", 3),
			of("5\n"
				+ "1 5 7 11 15\n"
				+ "39", 5),
			of("5\n"
				+ "1 8 20 25 50\n"
				+ "129", 5),
			of("11\n"
				+ "1 5 10 15 20 25 30 50 70 65 90\n"
				+ "390", 5),
			of("12\n"
				+ "1 5 10 15 20 25 30 50 70 65 90 100\n"
				+ "290", 3)
		);
	}
}
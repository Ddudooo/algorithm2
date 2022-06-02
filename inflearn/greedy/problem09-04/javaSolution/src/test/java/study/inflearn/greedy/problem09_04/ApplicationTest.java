package study.inflearn.greedy.problem09_04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem09_04_params")
	void solutionTest(String inputStr, int expect) {
		Application app = new Application();
		String[] splitInput = inputStr.trim().split("\n");
		int n = Integer.parseInt(splitInput[0].trim());
		Concert[] concerts = new Concert[n];
		for (int i = 0; i < n; i++) {
			int[] conditions = Arrays.stream(splitInput[i + 1].trim().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			concerts[i] = new Concert(conditions[0], conditions[1]);
		}
		int answer = app.solution(concerts);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem09_04_params() {
		return Stream.of(
			of("10\n"
				+ "13 2\n"
				+ "18 1\n"
				+ "68 10\n"
				+ "72 8\n"
				+ "11 7\n"
				+ "41 2\n"
				+ "48 7\n"
				+ "15 7\n"
				+ "34 1\n"
				+ "13 8\n", 302),
			of("5\n"
				+ "3 2\n"
				+ "65 1\n"
				+ "61 3\n"
				+ "60 2\n"
				+ "86 1\n", 207)
		);
	}
}
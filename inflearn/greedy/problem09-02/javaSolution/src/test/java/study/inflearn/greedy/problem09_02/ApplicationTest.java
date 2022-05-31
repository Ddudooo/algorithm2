package study.inflearn.greedy.problem09_02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem09_02_params")
	void solutionTest(String inputStr, int expect) {
		Application app = new Application();
		String[] splitInput = inputStr.trim().split("\n");
		int n = Integer.parseInt(splitInput[0]);
		Meeting[] meetings = new Meeting[n];
		for (int i = 1; i <= n; i++) {
			int[] conditions = Arrays.stream(splitInput[i].trim().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			meetings[i - 1] = new Meeting(conditions[0], conditions[1]);
		}

		int answer = app.solution(meetings);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem09_02_params() {
		return Stream.of(
			of("5\n"
				+ "1 4\n"
				+ "2 3\n"
				+ "3 5\n"
				+ "4 6\n"
				+ "5 7\n", 3),
			of("5\n"
				+ "3 3\n"
				+ "1 3\n"
				+ "2 3\n"
				+ "4 6\n"
				+ "5 7", 3)
		);
	}
}
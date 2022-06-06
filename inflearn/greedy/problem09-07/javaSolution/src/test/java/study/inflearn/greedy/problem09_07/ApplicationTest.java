package study.inflearn.greedy.problem09_07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem09_07_params")
	void solutionTest(String inputStr, int expect) {
		Application app = new Application();
		String[] splitStr = inputStr.trim().split("\n");
		int[] conditions = Arrays.stream(splitStr[0].trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int v = conditions[0];
		int e = conditions[1];
		Node[] nodes = new Node[e];
		for (int i = 0; i < e; i++) {
			int[] inputs = Arrays.stream(splitStr[i + 1].trim().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			nodes[i] = new Node(inputs[0], inputs[1], inputs[2]);
		}

		int answer = app.solution(v, nodes);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem09_07_params() {
		return Stream.of(
			of("9 12\n"
				+ "1 2 12\n"
				+ "1 9 25\n"
				+ "2 3 10\n"
				+ "2 8 40\n"
				+ "2 9 8\n"
				+ "3 4 18\n"
				+ "3 7 55\n"
				+ "4 5 44\n"
				+ "5 6 60\n"
				+ "5 7 38\n"
				+ "7 8 35\n"
				+ "8 9 35", 216),
			of("6 10\n"
				+ "1 2 4\n"
				+ "1 4 2\n"
				+ "1 5 1\n"
				+ "2 3 1\n"
				+ "2 5 3\n"
				+ "2 6 5\n"
				+ "3 5 6\n"
				+ "3 6 7\n"
				+ "4 5 2\n"
				+ "5 6 3", 10),
			of("5 7\n"
				+ "1 2 10\n"
				+ "1 3 6\n"
				+ "2 3 7\n"
				+ "2 4 4\n"
				+ "2 5 5\n"
				+ "3 4 5\n"
				+ "4 5 3", 18),
			of("11 17\n"
				+ "1 2 4\n"
				+ "1 3 1\n"
				+ "1 4 2\n"
				+ "1 5 3\n"
				+ "2 6 4\n"
				+ "3 4 2\n"
				+ "4 6 4\n"
				+ "4 7 4\n"
				+ "5 6 4\n"
				+ "6 10 2\n"
				+ "6 11 4\n"
				+ "7 8 3\n"
				+ "7 9 3\n"
				+ "7 10 4\n"
				+ "8 9 2\n"
				+ "9 10 2\n"
				+ "10 11 1\n", 24),
			of("13 22\n"
				+ "1 2 4\n"
				+ "1 3 1\n"
				+ "1 4 2\n"
				+ "1 5 3\n"
				+ "2 6 4\n"
				+ "3 4 2\n"
				+ "4 6 4\n"
				+ "4 7 4\n"
				+ "5 6 4\n"
				+ "6 10 2\n"
				+ "6 11 4\n"
				+ "7 8 3\n"
				+ "7 9 3\n"
				+ "7 10 4\n"
				+ "8 9 2\n"
				+ "9 10 2\n"
				+ "10 11 1\n"
				+ "11 12 3\n"
				+ "12 13 5\n"
				+ "9 13 2\n"
				+ "1 8 5\n"
				+ "1 9 1\n", 26)
		);
	}
}
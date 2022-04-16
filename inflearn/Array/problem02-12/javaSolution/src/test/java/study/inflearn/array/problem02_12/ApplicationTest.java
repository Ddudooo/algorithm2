package study.inflearn.array.problem02_12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem02_12_params")
	void solutionTest(String inputStr, int expect) {
		Application app = new Application();

		String[] splitStrs = inputStr.trim().split("\n");
		int[] sizes = Arrays.stream(splitStrs[0].split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = sizes[0];
		int m = sizes[1];
		int[][] scores = new int[m][n];
		for (int i = 0; i < m; i++) {
			scores[i] = Arrays.stream(splitStrs[i + 1].split(" ")).mapToInt(Integer::parseInt)
				.toArray();
		}

		int answer = app.solution(scores, n);

		assertEquals(expect, answer);
	}


	private static Stream<Arguments> problem02_12_params() {
		return Stream.of(
			of("4 3\n"
				+ "3 4 1 2\n"
				+ "4 3 2 1\n"
				+ "3 1 4 2\n", 3),
			of("20 2\n"
				+ "19 15 4 17 12 18 6 3 11 14 1 8 13 9 2 20 5 16 10 7\n"
				+ "5 20 18 17 14 11 19 3 10 16 6 8 13 9 2 12 4 7 1 15", 90),
			of("20 10\n"
				+ "15 7 16 10 1 17 8 4 11 14 6 9 18 20 13 19 2 5 12 3\n"
				+ "17 7 15 10 1 19 8 4 11 14 6 9 13 20 18 16 2 5 12 3\n"
				+ "19 7 15 10 1 16 8 11 4 14 6 9 18 20 13 17 2 5 12 3\n"
				+ "17 7 15 10 1 19 8 4 11 14 6 9 13 20 18 16 2 5 12 3\n"
				+ "16 7 15 10 1 19 8 4 11 9 6 14 18 20 13 17 2 5 12 3\n"
				+ "17 7 15 10 1 19 8 4 11 14 6 9 13 20 18 16 2 5 12 3\n"
				+ "16 7 15 2 1 19 8 4 11 14 6 9 18 20 13 17 10 5 12 3\n"
				+ "17 7 15 10 1 19 8 4 11 14 6 9 13 20 18 16 2 5 12 3\n"
				+ "16 7 15 10 1 19 8 14 11 4 6 9 18 20 13 17 2 5 12 3\n"
				+ "17 7 15 10 1 19 8 4 11 14 6 9 13 20 18 16 2 5 12 3", 115),
			of("20 10\n"
				+ "7 16 8 20 14 1 5 3 15 2 10 11 9 17 19 6 13 12 18 4\n"
				+ "7 16 8 20 14 1 5 3 15 2 10 11 9 17 19 6 13 12 18 4\n"
				+ "7 16 8 20 14 1 5 3 15 2 10 11 9 17 19 6 13 12 18 4\n"
				+ "7 16 8 20 14 1 5 3 15 2 10 11 9 17 19 6 13 12 18 4\n"
				+ "7 16 8 20 14 1 5 3 15 2 10 11 9 17 19 6 13 12 18 4\n"
				+ "7 16 8 20 14 1 5 3 15 2 10 11 9 17 19 6 13 12 18 4\n"
				+ "7 16 8 20 14 1 5 3 15 2 10 11 9 17 19 6 13 12 18 4\n"
				+ "7 16 8 20 14 1 5 3 15 2 10 11 9 17 19 6 13 12 18 4\n"
				+ "7 16 8 20 14 1 5 3 15 2 10 11 9 17 19 6 13 12 18 4\n"
				+ "7 16 8 20 14 1 5 3 15 2 10 11 9 17 19 6 13 12 18 4\n", 190),
			of("20 10\n"
				+ "5 11 19 8 20 13 1 14 7 3 2 15 4 18 10 9 17 12 16 6\n"
				+ "6 11 19 9 20 13 1 14 7 3 2 15 4 18 10 8 17 12 16 5\n"
				+ "5 11 19 8 20 13 1 14 7 3 2 15 4 18 10 9 17 12 16 6\n"
				+ "6 11 19 9 20 13 1 14 7 3 2 15 4 18 10 8 17 12 16 5\n"
				+ "5 11 19 8 20 13 1 14 7 3 2 15 4 18 10 9 17 12 16 6\n"
				+ "5 11 19 8 20 13 1 14 7 3 2 15 4 18 10 9 17 12 16 6\n"
				+ "6 11 19 9 20 13 1 14 7 3 2 15 4 18 10 8 17 12 16 5\n"
				+ "5 11 19 8 20 13 1 14 7 3 2 15 4 18 10 9 17 12 16 6\n"
				+ "6 11 19 9 20 13 1 14 7 3 2 15 4 18 10 8 17 12 16 5\n"
				+ "5 11 19 8 20 13 1 14 7 3 2 15 4 18 10 9 17 12 16 6\n", 130)

		);
	}
}
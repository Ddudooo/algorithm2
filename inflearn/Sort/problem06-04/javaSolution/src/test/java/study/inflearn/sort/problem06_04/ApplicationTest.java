package study.inflearn.sort.problem06_04;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem06_04_params")
	void solutionTest(String inputStr, String expectStr) {
		Application app = new Application();
		String[] splitInputs = inputStr.trim().split("\n");
		int[] conditions = Arrays.stream(splitInputs[0].trim().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		int[] inputs = Arrays.stream(splitInputs[1].trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();

		int[] answer = app.solution(inputs, conditions[0]);
		int[] expect = Arrays.stream(expectStr.trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();

		assertArrayEquals(expect, answer);
	}

	private static Stream<Arguments> problem06_04_params() {
		return Stream.of(
			of("3 10\n"
				+ "1 7 3 5 9 10 4 5 6 10", "10 6 5"),
			of("5 20\n"
				+ "8 5 17 8 4 9 12 4 7 19 5 19 8 15 11 12 1 4 17 18", "18 17 4 1 12"),
			of("10 50\n"
					+ "24 7 50 3 1 11 26 1 27 44 16 21 48 36 37 43 49 9 28 5 10 34 36 32 3 17 40 21 5 22 48 46 27 2 30 14 41 45 35 41 16 33 36 7 19 36 45 26 9 14",
				"14 9 26 45 36 19 7 33 16 41"),
			of("10 80\n"
					+ "96 17 60 52 23 20 79 62 27 23 95 11 44 44 17 61 72 4 57 44 88 47 52 2 82 78 97 77 8 32 4 41 9 2 1 48 43 71 64 95 17 44 48 51 33 59 37 87 36 14 60 72 69 34 30 99 40 21 58 89 32 29 3 33 78 30 85 65 99 77 29 54 92 10 71 78 12 59 11 87",
				"87 11 59 12 78 71 10 92 54 29"),
			of("10 100\n"
					+ "26 77 85 39 28 65 97 58 57 67 95 82 15 100 49 47 94 38 98 93 41 63 68 62 75 66 12 35 37 92 8 10 90 48 72 56 34 72 67 1 92 74 51 84 77 35 76 98 54 37 86 93 42 87 54 9 83 33 18 61 43 9 14 74 24 1 78 97 8 38 85 70 66 73 24 21 85 19 36 60 80 6 84 53 98 54 90 21 43 1 80 13 86 79 46 21 64 12 94 70",
				"70 94 12 64 21 46 79 86 13 80")
		);
	}

}
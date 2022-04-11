package study.inflearn.array.problem02_08;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem02_08_params")
	void solutionTest(String inputStr, String expectStr) {
		Application app = new Application();
		int[] input = Arrays.stream(inputStr.trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int[] result = app.solution(input);

		int[] expect = Arrays.stream(expectStr.trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();

		assertArrayEquals(expect, result);
	}

	private static Stream<Arguments> problem02_08_params() {
		return Stream.of(
			of("97 68 81 89 74 90 67", "1 6 4 3 5 2 7"),
			of(
				"65 54 81 56 54 70 61 87 99 58 78 99 99 70 96 60 77 84 67 86 84 98 63 96 83 54 52 86 78 69 ",
				"21 27 13 26 27 17 23 7 1 25 14 1 1 17 5 24 16 10 20 8 10 4 22 5 12 27 30 8 14 19"),
			of("56 54 68 65 55 69 61 69 98 82 63 51 60 72 69 79 82 73 88 69 82 89 54 92 88 91 68 75 77 62 50 55 70 90 55 74 78 58 53 53 90 80 58 68 92 51 63 82 81 97",
				"40 44 29 32 41 25 36 25 1 11 33 48 37 23 25 17 11 22 9 25 11 8 44 3 9 5 29 20 19 35 50 41 24 6 41 21 18 38 46 46 6 16 38 29 3 48 33 11 15 2"),
			of("67 59 59 90 65 91 58 92 55 62 60 99 68 79 92 68 95 94 94 59 79 81 88 79 88 88 57 71 75 56 61 64 70 70 89 62 94 54 69 73 76 96 53 62 76 52 70 86 88 75 59 50 92 54 84 88 97 71 81 71 70 75 92 55 74 91 84 57 67 51 52 69 63 53 94 96 92 87 86 79 61 98 86 92 61 91 86 52 66 95",
				"59 72 72 21 62 18 76 12 80 65 71 1 57 37 12 57 6 8 8 72 37 35 23 37 23 23 77 48 43 79 68 63 51 51 22 65 8 82 55 47 41 4 84 65 41 86 51 29 23 43 72 90 12 82 33 23 3 48 35 48 51 43 12 80 46 18 33 77 59 89 86 55 64 84 8 4 12 28 29 37 68 2 29 12 68 18 29 86 61 6"),
			of("77 89 53 63 71 61 82 96 65 65 65 62 78 58 64 81 54 94 77 55 67 74 75 96 89 82 94 89 53 50 66 60 87 81 78 61 61 78 87 93 74 90 88 63 96 76 70 67 61 58 94 70 94 90 76 76 54 54 52 69 71 97 51 71 86 81 97 68 63 82 87 52 92 54 73 90 57 92 64 90 58 53 76 58 77 70 52 56 77 94 69 72 63 71 67 88 71 92 93 57",
				"38 20 93 71 51 76 29 3 66 66 66 75 35 81 69 32 89 6 38 88 62 47 46 3 20 29 6 20 93 100 65 80 25 32 35 76 76 35 25 11 47 16 23 71 3 42 56 62 76 81 6 56 6 16 42 42 89 89 96 59 51 1 99 51 28 32 1 61 71 29 25 96 13 89 49 16 85 13 69 16 81 93 42 81 38 56 96 87 38 6 59 50 71 51 62 23 51 13 11 85")
		);
	}
}
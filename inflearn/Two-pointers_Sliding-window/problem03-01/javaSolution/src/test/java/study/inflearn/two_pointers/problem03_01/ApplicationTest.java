package study.inflearn.two_pointers.problem03_01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem03_01_params")
	void solutionTest(String inputStrs, String expectStr) {
		Application app = new Application();
		String[] splitStrs = inputStrs.trim().split("\n");
		int[] arrayA = Arrays.stream(splitStrs[1].trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int[] arrayB = Arrays.stream(splitStrs[3].trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int[] answer = app.mergeArraysOrderByASC(arrayA, arrayB);
		int[] expect = Arrays.stream(expectStr.trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();

		assertArrayEquals(expect, answer);
	}

	private static Stream<Arguments> problem03_01_params() {
		return Stream.of(
			of("10\n"
				+ "1 10 27 39 50 61 65 70 93 93 \n"
				+ "7\n"
				+ "7 51 65 66 70 82 93 ", "1 7 10 27 39 50 51 61 65 65 66 70 70 82 93 93 93"),
			of("9\n"
					+ "14 24 35 38 45 69 78 96 97 \n"
					+ "13\n"
					+ "1 15 27 29 40 50 58 63 70 74 75 82 99 ",
				"1 14 15 24 27 29 35 38 40 45 50 58 63 69 70 74 75 78 82 96 97 99"),
			of("20\n"
					+ "5 9 12 14 20 26 34 47 53 56 58 63 65 67 67 70 72 76 77 78 \n"
					+ "30\n"
					+ "1 19 20 22 28 30 30 36 41 45 53 55 59 65 66 74 77 78 79 81 82 84 84 88 89 90 91 93 96 97 ",
				"1 5 9 12 14 19 20 20 22 26 28 30 30 34 36 41 45 47 53 53 55 56 58 59 63 65 65 66 67 67 70 72 74 76 77 77 78 78 79 81 82 84 84 88 89 90 91 93 96 97"),
			of("60\n"
					+ "1 3 3 5 7 9 10 10 12 13 13 13 15 16 18 23 26 26 26 26 27 31 31 33 33 34 35 37 40 45 48 50 51 52 53 55 55 59 59 60 61 61 65 68 69 69 70 74 75 82 83 83 84 85 86 88 91 92 92 93 \n"
					+ "70\n"
					+ "7 7 9 9 10 11 11 16 21 22 22 23 25 26 27 28 30 30 32 32 35 39 40 41 42 42 47 48 49 49 49 50 50 52 57 58 61 64 64 65 65 66 67 70 70 78 80 80 81 81 82 82 82 83 84 85 85 86 89 90 91 92 93 94 94 95 95 96 97 98 ",
				"1 3 3 5 7 7 7 9 9 9 10 10 10 11 11 12 13 13 13 15 16 16 18 21 22 22 23 23 25 26 26 26 26 26 27 27 28 30 30 31 31 32 32 33 33 34 35 35 37 39 40 40 41 42 42 45 47 48 48 49 49 49 50 50 50 51 52 52 53 55 55 57 58 59 59 60 61 61 61 64 64 65 65 65 66 67 68 69 69 70 70 70 74 75 78 80 80 81 81 82 82 82 82 83 83 83 84 84 85 85 85 86 86 88 89 90 91 91 92 92 92 93 93 94 94 95 95 96 97 98"),
			of("90\n"
					+ "1 2 4 4 7 7 8 12 13 13 14 15 16 16 16 17 17 17 21 21 23 23 24 25 27 28 28 28 29 29 31 31 32 33 34 35 36 38 40 41 42 43 43 43 44 48 50 51 51 52 56 56 56 57 58 60 60 63 63 65 65 66 66 66 66 68 68 73 78 78 80 81 82 84 86 86 88 91 91 91 91 92 92 92 93 95 97 97 97 98 \n"
					+ "100\n"
					+ "5 6 6 7 8 9 9 9 12 13 14 16 16 17 18 21 22 22 23 23 24 24 25 25 26 26 26 26 26 27 28 28 30 31 32 32 32 33 33 34 35 35 38 38 38 38 39 41 42 43 44 47 51 51 51 53 56 56 56 56 57 57 59 61 62 65 66 66 67 74 76 76 77 77 77 79 82 82 83 85 87 89 89 90 90 90 91 91 91 91 94 95 95 95 96 96 99 99 100 100 ",
				"1 2 4 4 5 6 6 7 7 7 8 8 9 9 9 12 12 13 13 13 14 14 15 16 16 16 16 16 17 17 17 17 18 21 21 21 22 22 23 23 23 23 24 24 24 25 25 25 26 26 26 26 26 27 27 28 28 28 28 28 29 29 30 31 31 31 32 32 32 32 33 33 33 34 34 35 35 35 36 38 38 38 38 38 39 40 41 41 42 42 43 43 43 43 44 44 47 48 50 51 51 51 51 51 52 53 56 56 56 56 56 56 56 57 57 57 58 59 60 60 61 62 63 63 65 65 65 66 66 66 66 66 66 67 68 68 73 74 76 76 77 77 77 78 78 79 80 81 82 82 82 83 84 85 86 86 87 88 89 89 90 90 90 91 91 91 91 91 91 91 91 92 92 92 93 94 95 95 95 95 96 96 97 97 97 98 99 99 100 100")

		);
	}

}
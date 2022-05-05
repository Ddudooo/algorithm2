package study.inflearn.sort.problem06_02;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem06_02_params")
	void solutionTest(String inputStr, String expectStr) {
		Application app = new Application();
		String[] splitInputs = inputStr.trim().split("\n");
		int[] inputs = Arrays.stream(splitInputs[1].trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int[] answer = app.solution(inputs);
		int[] expect = Arrays.stream(expectStr.trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		assertArrayEquals(expect, answer);
	}

	private static Stream<Arguments> problem06_02_params() {
		return Stream.of(
			of("9\n"
				+ "3 7 1 5 4 2 9 8 6", "1 2 3 4 5 6 7 8 9"),
			of("10\n"
				+ "56 68 62 69 64 89 56 68 93 53", "53 56 56 62 64 68 68 69 89 93"),
			of("30\n"
					+ "88 74 68 55 72 50 55 56 93 82 75 95 67 82 80 91 82 72 54 61 73 82 92 77 75 85 69 55 53 98",
				"50 53 54 55 55 55 56 61 67 68 69 72 72 73 74 75 75 77 80 82 82 82 82 85 88 91 92 93 95 98"),
			of("60\n"
					+ "69 90 50 58 97 88 90 93 74 88 51 66 76 50 63 89 88 85 77 66 64 75 54 95 82 94 53 88 94 65 71 98 81 67 70 96 87 58 54 62 96 52 99 65 72 90 81 78 92 91 57 55 75 56 50 97 63 85 63 58",
				"50 50 50 51 52 53 54 54 55 56 57 58 58 58 62 63 63 63 64 65 65 66 66 67 69 70 71 72 74 75 75 76 77 78 81 81 82 85 85 87 88 88 88 88 89 90 90 90 91 92 93 94 94 95 96 96 97 97 98 99"),
			of("90\n"
					+ "97 81 99 82 91 61 61 84 88 93 83 52 93 67 92 79 56 83 92 79 93 66 93 91 50 92 52 94 75 99 72 70 61 91 60 50 53 65 55 87 62 57 82 67 72 77 51 81 52 91 80 88 62 73 63 64 90 54 71 52 72 99 85 72 80 78 99 74 95 55 95 61 91 81 95 91 54 80 79 86 93 78 92 71 95 59 96 87 78 91",
				"50 50 51 52 52 52 52 53 54 54 55 55 56 57 59 60 61 61 61 61 62 62 63 64 65 66 67 67 70 71 71 72 72 72 72 73 74 75 77 78 78 78 79 79 79 80 80 80 81 81 81 82 82 83 83 84 85 86 87 87 88 88 90 91 91 91 91 91 91 91 92 92 92 92 93 93 93 93 93 94 95 95 95 95 96 97 99 99 99 99")
		);
	}
}
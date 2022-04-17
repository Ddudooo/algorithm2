package study.inflearn.two_pointers.problem03_02;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem03_02_params")
	void solutionTest(String inputStr, String expectStr) {
		Application app = new Application();
		String[] inputSplit = inputStr.trim().split("\n");
		int[] arrayA = Arrays.stream(inputSplit[1].split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int[] arrayB = Arrays.stream(inputSplit[3].split(" ")).mapToInt(Integer::parseInt)
			.toArray();

		int[] answer = app.solution(arrayA, arrayB);
		int[] expect = Arrays.stream(expectStr.trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();

		assertArrayEquals(expect, answer);
	}

	private static Stream<Arguments> problem03_02_params() {
		return Stream.of(
			of("5\n"
				+ "1 3 9 5 2\n"
				+ "5\n"
				+ "3 2 5 7 8\n", "2 3 5\n"),
			of("3\n"
				+ "999999999 1000000000 5\n"
				+ "5\n"
				+ "999999999 1000000000 5 6 7", "5 999999999 1000000000")
		);
	}
}
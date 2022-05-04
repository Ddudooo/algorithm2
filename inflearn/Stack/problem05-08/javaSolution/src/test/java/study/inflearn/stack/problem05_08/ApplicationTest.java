package study.inflearn.stack.problem05_08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem05_08_params")
	void solutionTest(String inputStr, int expect) {
		Application app = new Application();
		String[] splitInputs = inputStr.trim().split("\n");
		int[] conditions = Arrays.stream(splitInputs[0].trim().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		int[] patients = Arrays.stream(splitInputs[1].trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();

		int answer = app.solution(patients, conditions[1]);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem05_08_params() {
		return Stream.of(
			of("5 2\n"
				+ "60 50 70 80 90", 3),
			of("6 0\n"
				+ "60 60 90 60 60 60", 5),
			of("15 5\n"
				+ "63 53 87 91 83 72 83 92 63 68 88 74 51 82 89", 10),
			of("50 15\n"
					+ "77 92 64 94 83 82 69 89 74 79 85 65 82 82 85 79 68 79 63 77 93 58 78 75 86 85 90 77 57 51 56 69 53 56 67 64 84 92 52 54 74 50 66 72 87 54 66 98 55 55",
				18),
			of("100 25\n"
					+ "70 81 58 71 62 68 92 63 50 53 53 61 77 96 67 60 74 54 91 81 65 65 82 50 95 98 87 93 70 72 90 62 64 99 74 73 67 95 71 82 61 96 57 84 84 91 52 50 88 90 77 54 50 70 52 99 99 83 72 57 78 61 54 59 58 78 79 75 84 78 95 61 61 50 90 76 51 55 64 99 50 72 61 77 72 93 62 87 76 57 62 74 94 71 98 84 63 74 73 68",
				6)
		);
	}
}
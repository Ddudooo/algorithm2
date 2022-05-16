package study.inflearn.dfs.problem08_03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem08_03_params")
	void solutionTest(String inputStr, int expect) {
		Application app = new Application();
		String[] split = inputStr.trim().split("\n");
		int[] conditions = Arrays.stream(split[0].trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		String[] inputs = Arrays.copyOfRange(split, 1, split.length);
		List<Problem> problemList = Arrays.stream(inputs).map(this::strToProblem)
			.collect(Collectors.toList());

		int answer = app.solution(problemList, conditions[1]);

		assertEquals(expect, answer);
	}

	private Problem strToProblem(String input) {
		int[] inputs = Arrays.stream(input.trim().split(" ")).mapToInt(Integer::parseInt).toArray();
		return new Problem(inputs[0], inputs[1]);
	}

	private static Stream<Arguments> problem08_03_params() {
		return Stream.of(
			of("5 20\n"
				+ "10 5\n"
				+ "25 12\n"
				+ "15 8\n"
				+ "6 3\n"
				+ "7 4", 41),
			of("9 50\n"
				+ "12 7\n"
				+ "16 8\n"
				+ "20 10\n"
				+ "30 15\n"
				+ "10 5\n"
				+ "25 12\n"
				+ "15 8\n"
				+ "6 3\n"
				+ "7 4", 101),
			of("12 70\n"
				+ "5 2\n"
				+ "11 5\n"
				+ "12 7\n"
				+ "16 8\n"
				+ "20 10\n"
				+ "30 15\n"
				+ "10 5\n"
				+ "25 12\n"
				+ "15 8\n"
				+ "6 3\n"
				+ "7 4\n"
				+ "3 2", 141),
			of("15 150\n"
				+ "5 2\n"
				+ "11 5\n"
				+ "12 7\n"
				+ "16 8\n"
				+ "20 10\n"
				+ "30 15\n"
				+ "10 5\n"
				+ "25 12\n"
				+ "15 8\n"
				+ "6 3\n"
				+ "7 4\n"
				+ "3 2\n"
				+ "8 5\n"
				+ "9 12\n"
				+ "19 11", 196),
			of("19 150\n"
				+ "16 11\n"
				+ "20 16\n"
				+ "11 6\n"
				+ "5 2\n"
				+ "11 5\n"
				+ "12 7\n"
				+ "16 8\n"
				+ "20 10\n"
				+ "30 15\n"
				+ "10 5\n"
				+ "25 12\n"
				+ "15 8\n"
				+ "6 3\n"
				+ "7 4\n"
				+ "3 2\n"
				+ "8 5\n"
				+ "9 12\n"
				+ "19 11\n"
				+ "9 6", 252)
		);
	}
}
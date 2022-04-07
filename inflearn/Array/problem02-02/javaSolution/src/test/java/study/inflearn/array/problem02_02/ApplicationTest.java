package study.inflearn.array.problem02_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class ApplicationTest {

	@ParameterizedTest
	@CsvFileSource(resources = "/problem02-02/params.csv", numLinesToSkip = 1, maxCharsPerColumn = 64000)
	void solutionTest(String input, int expect) {
		Application app = new Application();
		int[] students = Arrays.stream(input.trim().split(" ")).mapToInt(Integer::valueOf)
			.toArray();

		int answer = app.solution(students);

		assertEquals(expect, answer);
	}
}
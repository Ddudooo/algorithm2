package study.inflearn.array.problem02_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class ApplicationTest {

	@ParameterizedTest
	@CsvFileSource(resources = "/data/params.csv", numLinesToSkip = 1, delimiter = ',', maxCharsPerColumn = 64000)
	void solutionTest(int n, String expectStr) {
		Application app = new Application();
		
		String answerStr = Arrays.stream(app.solution(n)).mapToObj(String::valueOf).collect(
			Collectors.joining(" "));

		assertEquals(expectStr, answerStr);
	}

}
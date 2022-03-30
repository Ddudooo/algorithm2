package study.problem01_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {


	@ParameterizedTest
	@MethodSource("problem01_01_parameters")
	void solution(String input1, char input2, long expect) {
		// given
		Application app = new Application();

		// when
		long answer = app.solution(input1, input2);

		// then
		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem01_01_parameters() {
		return Stream.of(
			Arguments.of("computerprogramming", 'r', 3),
			Arguments.of("Computercooler", 'c', 2),
			Arguments.of("sssssss", 's', 7),
			Arguments.of("itistimetogoii", 'i', 5),
			Arguments.of("tttccttccTT", 'T', 7)
		);
	}
}
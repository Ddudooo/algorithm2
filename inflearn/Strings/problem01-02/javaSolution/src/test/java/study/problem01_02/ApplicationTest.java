package study.problem01_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem01_02_parameters")
	void solutionTest(String input, String expect) {
		String answer = Application.solution(input);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem01_02_parameters() {
		return Stream.of(
			Arguments.of("StuDY", "sTUdy"),
			Arguments.of("dkfHHLkdjlgKHL", "DKFhhlKDJLGkhl"),
			Arguments.of("znlakHLnvLHHLgkdieytYOY", "ZNLAKhlNVlhhlGKDIEYTyoy"),
			Arguments.of("dkieoYOIUOotokdjgljajYOYOHKGhkgLKJLKJgBlkBlLJ",
				"DKIEOyoiuoOTOKDJGLJAJyoyohkgHKGlkjlkjGbLKbLlj"),
			Arguments.of("djkjgKLUOIHkjHGYhUYFUYGjGUYGUYfUFUGUguYURrUHGUYUguOK",
				"DJKJGkluoihKJhgyHuyfuygJguyguyFufuguGUyurRuhguyuGUok")
		);
	}
}
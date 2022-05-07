package study.inflearn.sort.problem06_06;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem06_06_params")
	void solutionTest(String inputStr, String expectStr) {
		Application app = new Application();
		String[] split = inputStr.trim().split("\n");
		int[] inputs = Arrays.stream(split[1].trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int[] answer = app.solution(inputs);
		int[] expect = Arrays.stream(expectStr.trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		assertArrayEquals(expect, answer);
	}

	private static Stream<Arguments> problem06_06_params() {
		return Stream.of(
			of("9\n"
				+ "120 125 152 130 135 135 143 127 160", "3 8"),
			of("10\n"
				+ "125 161 138 140 145 147 154 154 130 173", "2 9"),
			of("30\n"
					+ "122 123 125 125 128 130 133 137 138 138 140 141 142 143 145 147 149 149 154 154 155 157 161 167 167 167 161 170 173 173",
				"24 27"),
			of("60\n"
					+ "122 123 124 125 125 126 128 130 130 133 136 136 137 138 138 138 140 140 141 141 141 142 143 144 144 145 146 147 147 149 149 149 149 150 151 151 153 154 154 155 157 157 159 173 161 161 161 162 164 165 165 166 167 167 167 168 170 173 160 176",
				"44 59"),
			of("70\n"
					+ "122 123 124 125 125 126 128 130 130 133 136 136 137 138 138 138 140 140 141 141 141 142 143 144 144 145 146 147 147 149 149 149 149 150 183 151 153 154 154 155 157 157 159 160 161 161 161 162 164 165 165 166 167 167 167 168 170 173 173 176 177 177 179 180 180 181 183 183 183 151",
				"35 70")
		);
	}
}
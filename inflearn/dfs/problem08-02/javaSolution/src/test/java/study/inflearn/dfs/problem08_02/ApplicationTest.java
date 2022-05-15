package study.inflearn.dfs.problem08_02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem08_02_params")
	void solutionTest(String inputStr, int expect) {
		Application app = new Application();
		String[] split = inputStr.trim().split("\n");
		int[] conditions = Arrays.stream(split[0].trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int[] inputs = new int[conditions[1]];
		for (int i = 1; i <= conditions[1]; i++) {
			inputs[i - 1] = Integer.parseInt(split[i].trim());
		}

		int answer = app.solution(inputs, conditions[0]);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem08_02_params() {
		return Stream.of(
			of("4000 16\n"
				+ "27\n"
				+ "303\n"
				+ "251\n"
				+ "121\n"
				+ "50\n"
				+ "55\n"
				+ "123\n"
				+ "93\n"
				+ "360\n"
				+ "84\n"
				+ "353\n"
				+ "429\n"
				+ "765\n"
				+ "391\n"
				+ "562\n"
				+ "77\n", 3994),
			of("3570 15\n"
				+ "27\n"
				+ "303\n"
				+ "251\n"
				+ "121\n"
				+ "50\n"
				+ "55\n"
				+ "123\n"
				+ "93\n"
				+ "360\n"
				+ "84\n"
				+ "353\n"
				+ "429\n"
				+ "765\n"
				+ "391\n"
				+ "562\n", 3568),
			of("100000000 20\n"
				+ "27\n"
				+ "12\n"
				+ "25\n"
				+ "13\n"
				+ "50\n"
				+ "55\n"
				+ "123\n"
				+ "93\n"
				+ "36\n"
				+ "84\n"
				+ "35\n"
				+ "42\n"
				+ "76\n"
				+ "39\n"
				+ "56\n"
				+ "65\n"
				+ "89\n"
				+ "18\n"
				+ "59\n"
				+ "38", 1035),
			of("100000000 21\n"
				+ "27\n"
				+ "567\n"
				+ "999\n"
				+ "234\n"
				+ "50\n"
				+ "567\n"
				+ "123\n"
				+ "4734\n"
				+ "754\n"
				+ "84\n"
				+ "35\n"
				+ "1353\n"
				+ "76\n"
				+ "464\n"
				+ "4634\n"
				+ "65\n"
				+ "89\n"
				+ "3553\n"
				+ "59\n"
				+ "38\n"
				+ "4135", 22640),
			of("10000 12\n"
				+ "2757\n"
				+ "5674\n"
				+ "9996\n"
				+ "2346\n"
				+ "4673\n"
				+ "5673\n"
				+ "1236\n"
				+ "4734\n"
				+ "754\n"
				+ "4534\n"
				+ "3563\n"
				+ "1", 9997)
		);
	}
}
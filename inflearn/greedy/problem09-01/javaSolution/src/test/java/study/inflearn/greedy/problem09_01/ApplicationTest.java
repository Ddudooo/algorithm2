package study.inflearn.greedy.problem09_01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem09_01_params")
	void solutionTest(String inputStr, int expect) {
		Application app = new Application();
		String[] splitInputs = inputStr.trim().split("\n");
		int n = Integer.parseInt(splitInputs[0]);
		Player[] players = new Player[n];
		for (int i = 0; i < n; i++) {
			int[] input = Arrays.stream(splitInputs[i + 1].trim().split(" "))
				.mapToInt(Integer::parseInt).toArray();
			players[i] = new Player(input[0], input[1]);
		}

		int answer = app.solution(players);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem09_01_params() {
		return Stream.of(
			of("5\n"
				+ "172 67\n"
				+ "183 65\n"
				+ "180 70\n"
				+ "170 72\n"
				+ "181 60\n", 3),
			of("15\n"
				+ "192 117\n"
				+ "190 110\n"
				+ "184 98\n"
				+ "212 91\n"
				+ "177 89\n"
				+ "218 78\n"
				+ "152 106\n"
				+ "182 64\n"
				+ "193 88\n"
				+ "198 71\n"
				+ "216 111\n"
				+ "155 101\n"
				+ "181 92\n"
				+ "173 77\n"
				+ "215 97", 3),
			of("25\n"
				+ "193 61\n"
				+ "215 106\n"
				+ "187 63\n"
				+ "192 73\n"
				+ "150 50\n"
				+ "195 76\n"
				+ "196 67\n"
				+ "191 52\n"
				+ "197 59\n"
				+ "179 101\n"
				+ "168 75\n"
				+ "218 74\n"
				+ "183 108\n"
				+ "219 70\n"
				+ "172 91\n"
				+ "157 96\n"
				+ "175 109\n"
				+ "152 72\n"
				+ "203 64\n"
				+ "214 54\n"
				+ "202 104\n"
				+ "194 119\n"
				+ "178 120\n"
				+ "188 60\n"
				+ "151 66", 5),
			of("35\n"
				+ "168 63\n"
				+ "190 57\n"
				+ "209 107\n"
				+ "218 83\n"
				+ "153 97\n"
				+ "156 116\n"
				+ "188 72\n"
				+ "195 96\n"
				+ "211 69\n"
				+ "189 53\n"
				+ "187 115\n"
				+ "178 88\n"
				+ "163 98\n"
				+ "182 77\n"
				+ "157 81\n"
				+ "198 71\n"
				+ "162 58\n"
				+ "165 85\n"
				+ "219 73\n"
				+ "152 65\n"
				+ "214 67\n"
				+ "208 68\n"
				+ "212 106\n"
				+ "160 56\n"
				+ "183 94\n"
				+ "174 104\n"
				+ "173 55\n"
				+ "193 59\n"
				+ "194 90\n"
				+ "169 66\n"
				+ "199 62\n"
				+ "184 79\n"
				+ "150 100\n"
				+ "191 87\n"
				+ "213 119", 3),
			of("50\n"
				+ "201 67\n"
				+ "198 119\n"
				+ "177 110\n"
				+ "169 112\n"
				+ "174 61\n"
				+ "163 62\n"
				+ "151 105\n"
				+ "195 70\n"
				+ "207 91\n"
				+ "206 102\n"
				+ "159 79\n"
				+ "186 103\n"
				+ "150 65\n"
				+ "199 57\n"
				+ "190 113\n"
				+ "153 73\n"
				+ "171 71\n"
				+ "187 77\n"
				+ "212 51\n"
				+ "218 92\n"
				+ "205 64\n"
				+ "211 78\n"
				+ "155 121\n"
				+ "180 90\n"
				+ "214 56\n"
				+ "166 53\n"
				+ "210 108\n"
				+ "183 117\n"
				+ "202 107\n"
				+ "181 88\n"
				+ "178 87\n"
				+ "192 55\n"
				+ "193 86\n"
				+ "216 109\n"
				+ "157 82\n"
				+ "154 54\n"
				+ "158 80\n"
				+ "203 115\n"
				+ "197 104\n"
				+ "217 68\n"
				+ "191 66\n"
				+ "173 98\n"
				+ "188 59\n"
				+ "182 114\n"
				+ "172 120\n"
				+ "161 81\n"
				+ "200 106\n"
				+ "152 74\n"
				+ "184 72\n"
				+ "213 95", 6)
		);
	}
}
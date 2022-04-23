package study.inflearn.hash.problem04_02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem04_02_params")
	void solutionTest(String inputs, String expect) {
		Application app = new Application();
		String[] splitInput = Arrays.stream(inputs.split("\n")).map(String::trim)
			.toArray(String[]::new);
		boolean checked = app.isAnagram(splitInput[0], splitInput[1]);
		String output = checked ? "YES" : "NO";

		assertEquals(expect, output);
	}

	private static Stream<Arguments> problem04_02_params() {
		return Stream.of(
			of("AbaAeCe\n"
				+ "baeeACA", "YES"),
			of("ade\n"
				+ "bdd", "NO"),
			of("ABCEFGHIJKLMNPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz\n"
				+ "bcdEfgHiJKLmnopRSstVvXYZzABCeFGhIjklMNPQqrTUuWwxya", "YES"),
			of("ABCDqtqtqEFqGHIJKLMNOPQRSTUVWetagdgXYabcdefghijklmnopqrstuwxyz\n"
				+ "aBcdewrqwtqFghIJklMnOpqrsTuegagaeVxyYAbCDEfGHijKLmNoPQRStUwWXz", "NO"),
			of("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnoqrtuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnoqrtuvwxyz\n"
					+ "ZBCcdFfgIJKLMNOPQRSTvVxyYAabDEeGHhijklmnoqrtuUwWXzZBCcdFfgIJKLMNOPQRSTvVxyYAabDEeGHhijklmnoqrtuUwWXz",
				"YES")
		);
	}
}
package study.inflearn.stack.problem05_02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem05_02_params")
	void solutionTest(String input, String expect) {
		Application app = new Application();

		String answer = app.solution(input);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem05_02_params() {
		return Stream.of(
			of("(AGKD)KDK(TKDM(KD))", "KDK"),
			of("(AGKD)KDK(TKDM(KD))(ADKF(DK)DKF)DKF", "KDKDKF"),
			of("(AGKD)KDK(TKDM(KD))(ADKF(DK)DKF)DKF(dkf)dkf(d(D)dd)", "KDKDKFdkf"),
			of("(AGKD)KDK(TKDM(KD))(ADKF(DK)DKF)DKF(dkf)dkf(d(D)dd)(DFS(d))dD", "KDKDKFdkfdD"),
			of("(AGKD)KDK(TKDM(KD))(ADKF(DK)DKF)DKF(dkf)dkf(d(D)dd)(DFS(d))dD(dk)DDD",
				"KDKDKFdkfdDDDD")
		);
	}
}
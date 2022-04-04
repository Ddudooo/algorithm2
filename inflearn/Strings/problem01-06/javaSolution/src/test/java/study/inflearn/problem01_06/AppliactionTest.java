package study.inflearn.problem01_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AppliactionTest {

	@ParameterizedTest
	@MethodSource("problem01_06_params")
	void solutionTest(String input, String expect) {
		Appliaction app = new Appliaction();

		String answer = app.solution(input);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem01_06_params() {
		return Stream.of(
			Arguments.of("ksekkset", "kset"),
			Arguments.of("kjkgjlskjekieogiwo", "kjglseiow"),
			Arguments.of("kdkgksjgkjlsjgkjsljgkjaksjg", "kdgsjla"),
			Arguments.of("eiotuoiwtitoiywiotieoiutoiwioweuotiuwoieut", "eiotuwy"),
			Arguments.of("qiutoiwuotiqpituoiwuiotuowutowiutoityioqp", "qiutowpy")
		);
	}
}
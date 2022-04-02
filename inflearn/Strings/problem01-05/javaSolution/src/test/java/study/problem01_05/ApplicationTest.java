package study.problem01_05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest {

	@ParameterizedTest
	@MethodSource("problem01_05_params")
	void solutionTest(String input, String expect) {
		Application app = new Application();

		String answer = app.alphabetReverse(input);

		assertEquals(expect, answer);
	}

	private static Stream<Arguments> problem01_05_params() {
		return Stream.of(
			of("a#b!GE*T@S", "S#T!EG*b@a"),
			of("kdj#@kdjg%$#kdjgk@kd$dk", "kdd#@kkgj%$#dkgjd@kj$dk"),
			of("kqQdj#@kd#g%$#kdj&&gk@kd$dQGk", "kGQdd#@kk#g%$#jdk&&gd@kj$dQqk"),
			of("kqQ!DGSGSdj#@kd#g%$#kdj&&gk@kd$d#%&DGS@!DHSQGk",
				"kGQ!SHDSGDd#@dk#k%$#gjd&&kg@dk$j#%&dSG@!SGDQqk"),
			of("kHSHHS#qQ!DGSG#@Sdj#@kd#g%$#kdj&&gk@kd$d#%&DGS@!DH%SQGk#",
				"kGQSHD#SG!Dddk#@kgj#@dk#g%$#dkj&&dS@GS$G#%&DQq@!SH%HSHk#")
		);
	}
}
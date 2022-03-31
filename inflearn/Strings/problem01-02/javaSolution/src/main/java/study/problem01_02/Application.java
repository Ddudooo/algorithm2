package study.problem01_02;

import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;

import java.io.StringWriter;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		String answer = solution(input);
		System.out.println(answer);
	}

	public static String solution(String input) {
		return input.chars()
			.collect(
				StringWriter::new,
				(sw, ch) -> sw.write((isUpperCase(ch) ? toLowerCase(ch) : toUpperCase(ch))),
				(swl, swr) -> swl.write(swr.toString())
			)
			.toString();
	}
}
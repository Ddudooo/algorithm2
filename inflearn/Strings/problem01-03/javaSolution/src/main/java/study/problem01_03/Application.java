package study.problem01_03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		System.out.println(solution(input));
	}

	public static String solution(String input) {
		return Arrays.stream(input.split("\\s+"))
			.max(Comparator.comparingInt(String::length))
			.orElseGet(String::new);
	}
}
package study.problem01_01;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input1 = in.next();
		String input2 = in.next();
		long answer = solution(input1, input2.charAt(0));
		System.out.println(answer);
	}

	public static long solution(String str, char character) {
		return str.toUpperCase()
			.chars()
			.filter(c -> c == Character.toUpperCase(character))
			.count();
	}
}
package study.inflearn.stack.problem05_05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		int answer = app.solution(input);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(String input) {
		int result = 0;
		char[] charArray = input.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < charArray.length; i++) {
			char inputChar = charArray[i];
			if (inputChar == ')') {
				if (!stack.isEmpty() && charArray[i - 1] == '(') {
					stack.pop();
					result += stack.size();
				} else {
					stack.pop();
					result++;
				}
			} else {
				stack.push(inputChar);
			}
		}
		return result;
	}
}

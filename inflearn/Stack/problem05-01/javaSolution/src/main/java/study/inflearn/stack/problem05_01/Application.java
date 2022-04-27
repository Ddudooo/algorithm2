package study.inflearn.stack.problem05_01;

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
		String input = br.readLine().trim();
		boolean answer = app.solution(input);
		bw.write(answer ? "YES" : "NO");
		bw.flush();
		bw.close();
		br.close();
	}

	public boolean solution(String input) {
		Stack<Character> stack = new Stack<>();
		for (char c : input.toCharArray()) {
			if (c == '(') {
				stack.add(c);
			} else {
				if (stack.isEmpty()) {
					stack.add(c);
				} else if (stack.peek() == '(') {
					stack.pop();
				} else {
					stack.add(c);
				}
			}
		}

		return stack.isEmpty();
	}
}
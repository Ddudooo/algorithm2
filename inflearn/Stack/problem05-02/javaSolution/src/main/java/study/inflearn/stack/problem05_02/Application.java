package study.inflearn.stack.problem05_02;

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
		bw.write(app.solution(input));
		bw.flush();
		bw.close();
		bw.close();
	}

	public String solution(String input) {
		Stack<Character> stack = new Stack<>();
		int count = 0;
		for (char c : input.toCharArray()) {
			if (c == '(') {
				count++;
			} else if (c == ')' && count > 0) {
				while (!stack.empty() && stack.pop() != '(') {
//					stack.pop();
				}
				continue;
			}
			stack.add(c);
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.empty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}
}

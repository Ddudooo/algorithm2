package study.inflearn.stack.problem05_04;

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
		char[] chars = input.toCharArray();
		Stack<Integer> stack = new Stack<>();
		for (char inputChar : chars) {
			if (Character.isDigit(inputChar)) {
				stack.push(Character.getNumericValue(inputChar));
			} else if (!stack.isEmpty()) {
				int right = stack.pop();
				int left = stack.pop();
				int operationResult = this.operation(inputChar, left, right);
				stack.push(operationResult);
			}
		}
		return stack.pop();
	}

	private int operation(char inputChar, int leftOperand, int rightOperand) {
		switch (inputChar) {
			case '+':
				return leftOperand + rightOperand;
			case '-':
				return leftOperand - rightOperand;
			case '*':
				return leftOperand * rightOperand;
			case '/':
				return leftOperand / rightOperand;
			default:
				throw new RuntimeException("unable operation");
		}
	}
}

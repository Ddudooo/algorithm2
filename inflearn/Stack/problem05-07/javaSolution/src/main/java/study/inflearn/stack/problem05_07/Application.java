package study.inflearn.stack.problem05_07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String condition = br.readLine().trim();
		String inputClass = br.readLine().trim();
		boolean answer = app.solution(condition, inputClass);
		bw.write(answer ? "YES" : "NO");
		bw.flush();
		bw.close();
		br.close();
	}

	public boolean solution(String condition, String input) {
		Queue<Character> planQueue = condition.chars()
			.mapToObj(c -> (char) c)
			.collect(Collectors.toCollection(LinkedList::new));
		for (char c : input.toCharArray()) {
			if (planQueue.isEmpty()) {
				break;
			} else if (planQueue.peek() == c) {
				planQueue.poll();
			}
		}
		return planQueue.isEmpty();
	}

}

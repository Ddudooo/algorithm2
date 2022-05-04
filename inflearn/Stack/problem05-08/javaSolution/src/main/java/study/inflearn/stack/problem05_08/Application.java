package study.inflearn.stack.problem05_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] conditions = Arrays.stream(br.readLine().trim().split(" "))
			.mapToInt(Integer::parseInt).toArray();
		int[] patients = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int answer = app.solution(patients, conditions[1]);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int[] patients, int m) {
		int result = 0;
		int pointer = m;
		List<Integer> patientsList = Arrays.stream(patients).boxed().collect(Collectors.toList());
		Queue<Integer> queue = new LinkedList<>(patientsList);
		Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		priorityQueue.addAll(patientsList);
		while (!queue.isEmpty()) {
			int next = queue.poll();
			int peek = priorityQueue.peek();
			if (next == peek) {
				priorityQueue.poll();
				result++;
				if (pointer == 0) {
					break;
				}
			}
			queue.add(next);
			pointer = --pointer >= 0 ? pointer : queue.size() - 1;
		}
		return result;
	}
}

package study.inflearn.bfs.problem07_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Application {

	private static final int STEP_FORWARD = 1;
	private static final int JUMP_FORWARD = 5;
	private static final int STEP_BACK = -1;

	private static final int[] STEPS = {STEP_FORWARD, STEP_BACK, JUMP_FORWARD};

	public static void main(String[] args) throws IOException {
		try {
			Application app = new Application();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int[] inputs = Arrays.stream(br.readLine().trim().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			int answer = app.solution(inputs[0], inputs[1]);
			bw.write(String.format("%d", answer));
			bw.flush();
			bw.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int solution(int start, int end) {
		int result = 0;
		boolean[] check = new boolean[10001];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			int numberOfCase = queue.size();
			for (int i = 0; i < numberOfCase; i++) {
				int currentCase = queue.poll();
				if (isChecked(check, currentCase)) {
					continue;
				}
				if (currentCase == end) {
					return result;
				}
				for (int step : STEPS) {
					int nextStep = currentCase + step;
					if (nextStep == end) {
						return ++result;
					}
					if (nextStep > 1) {
						queue.add(nextStep);
					}
				}
			}
			result++;
		}
		return result;
	}

	private boolean isChecked(boolean[] check, int currentCase) {
		if (check[currentCase]) {
			return true;
		}
		check[currentCase] = true;
		return false;
	}
}

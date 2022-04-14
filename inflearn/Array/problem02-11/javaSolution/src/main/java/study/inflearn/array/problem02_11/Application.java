package study.inflearn.array.problem02_11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] history = new int[n][5];
		for (int i = 0; i < n; i++) {
			history[i] = Arrays.stream(br.readLine().trim().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		int answer = app.solution(history, n);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int[][] history, int n) {
		int[] count = new int[n + 1];
		for (int i = 0; i < n; i++) {
			boolean[] checks = new boolean[n];
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				for (int k = 0; k < 5; k++) {
					int studentA = history[i][k];
					int studentB = history[j][k];
					if (studentA == studentB) {
						checks[j] = true;
					}
				}
			}
			count[i + 1] = getTrueCount(checks);
		}
		return getMaxStudent(n, count);
	}

	private int getMaxStudent(int n, int[] count) {
		int max = Integer.MIN_VALUE;
		int result = 1;
		for (int i = 1; i <= n; i++) {
			if (max < count[i]) {
				result = i;
				max = count[i];
			}
		}
		return result;
	}

	private int getTrueCount(boolean[] checks) {
		int count = 0;
		for (boolean check : checks) {
			if (check) {
				count++;
			}
		}
		return count;
	}
}
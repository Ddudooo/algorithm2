package study.inflearn.array.problem02_12;

import static java.lang.Math.min;

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
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = size[0];
		int m = size[1];
		int[][] scores = new int[m][n];
		for (int i = 0; i < m; i++) {
			scores[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
				.toArray();
		}
		int answer = app.solution(scores, n);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int[][] scores, int studentSize) {
		int result = 0;
		for (int i = 0; i < studentSize; i++) {
			for (int j = 0; j < studentSize; j++) {
				if (i == j) {
					continue;
				}
				if (isPairable(i + 1, j + 1, scores)) {
					result++;
				}
			}
		}
		return result;
	}

	private boolean isPairable(int mento, int menti, int[][] scores) {
		for (int[] curScores : scores) {
			int mentoIdx = -1;
			int mentiIdx = -1;
			for (int i = 0; i < curScores.length; i++) {
				int score = curScores[i];
				if (mento == score) {
					mentoIdx = i;
				}
				if (menti == score) {
					mentiIdx = i;
				}
				if (min(mentoIdx, mentiIdx) >= 0) {
					break;
				}
			}
			if (mentiIdx < mentoIdx) {
				return false;
			}
		}
		return true;
	}
}
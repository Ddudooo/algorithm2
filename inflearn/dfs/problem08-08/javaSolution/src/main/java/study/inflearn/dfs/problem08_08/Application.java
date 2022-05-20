package study.inflearn.dfs.problem08_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Application {

	private int[] combinations;
	private int n = 0;
	private int f = 0;
	private int[] temp;
	private int[] answer;
	private boolean[] check;
	private boolean isDone = false;

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] conditions = Arrays.stream(br.readLine().trim().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		int[] answers = app.solution(conditions[0], conditions[1]);
		String answerStr = Arrays.stream(answers).boxed().map(String::valueOf)
			.collect(Collectors.joining(" "));
		bw.write(answerStr);
		bw.flush();
		bw.close();
		br.close();
	}

	private int comb(int c, int r) {
		if (r == 0 || r == c) {
			return 1;
		}
		return comb(c - 1, r - 1) + comb(c - 1, r);
	}

	public int[] solution(int n, int f) {
		this.n = n;
		this.f = f;
		combinations = new int[n];
		answer = new int[n];
		temp = new int[n];
		check = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			combinations[i] = comb(n - 1, i);
		}
		dfs(0, 0);
		return answer;
	}

	private void dfs(int idx, int sum) {
		if (isDone) {
			return;
		}
		if (idx == n) {
			if (sum == f) {
				isDone = true;
				answer = Arrays.copyOfRange(temp, 0, n);
				return;
			}
		}
		for (int i = 1; i <= n; i++) {
			if (!check[i]) {
				check[i] = true;
				temp[idx] = i;
				dfs(idx + 1, sum + (combinations[idx] * temp[idx]));
				check[i] = false;
			}
		}
	}
}

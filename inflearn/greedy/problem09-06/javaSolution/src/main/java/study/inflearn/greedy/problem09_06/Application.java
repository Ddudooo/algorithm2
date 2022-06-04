package study.inflearn.greedy.problem09_06;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Application {

	private boolean check = false;

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] conditions = Arrays.stream(br.readLine().trim().split(" "))
			.mapToInt(Integer::parseInt).toArray();
		int n = conditions[0]; // 숫자 갯수
		int m = conditions[1]; // 숫자쌍
		Pair[] pairs = new Pair[m];
		for (int i = 0; i < m; i++) {
			int[] inputs = Arrays.stream(br.readLine().trim().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			pairs[i] = new Pair(inputs[0], inputs[1]);
		}
		int[] inputs = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		Pair question = new Pair(inputs[0], inputs[1]);
		boolean answer = app.solution(question, pairs);
		bw.write(answer ? "YES" : "NO");
		bw.flush();
		bw.close();
		br.close();
	}

	public boolean solution(Pair question, Pair[] pairs) {
		int st = min(question.a, question.b);
		int end = max(question.a, question.b);
		boolean[] visit = new boolean[pairs.length];
		find(st, end, pairs, visit);
		return check;
	}

	private void find(int st, int end, Pair[] pairs, boolean[] visit) {
		if (check) {
			return;
		}
		if (st == end) {
			check = true;
			return;
		}
		for (int i = 0; i < pairs.length; i++) {
			if (visit[i]) {
				continue;
			}
			Pair pair = pairs[i];
			if (pair.a == st) {
				visit[i] = true;
				find(pair.b, end, pairs, visit);
			} else if (pair.b == st) {
				visit[i] = true;
				find(pair.a, end, pairs, visit);
			}
		}
	}
}

class Pair {

	final int a;
	final int b;

	Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
}



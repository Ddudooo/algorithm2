package study.inflearn.dfs.problem08_01;

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
		int n = Integer.parseInt(br.readLine().trim());
		int[] inputs = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		boolean answer = app.solution(inputs);
		bw.write(answer ? "YES" : "NO");
		bw.flush();
		bw.close();
		br.close();
	}

	public boolean solution(int[] inputs) {
		check(inputs, 0, 0);
		return check;
	}

	public void check(int[] inputs, int idx, int result) {
		if (check) {
			return;
		}
		if (idx == inputs.length) {
			if (result == Arrays.stream(inputs).sum() - result) {
				check = true;
			}
		} else {
			check(inputs, idx + 1, result);
			check(inputs, idx + 1, result + inputs[idx]);
		}
	}
}

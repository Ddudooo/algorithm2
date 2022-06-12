package study.inflearn.dp.problem10_03;

import static java.lang.Math.max;

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
		int n = Integer.parseInt(br.readLine().trim());
		int[] inputs = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int answer = app.solution(inputs);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int[] inputs) {
		int[] dp = new int[inputs.length];
		Arrays.fill(dp, 1);
		for (int i = 0; i < inputs.length; i++) {
			for (int j = 0; j < i; j++) {
				if (inputs[j] < inputs[i]) {
					dp[i] = max(dp[i], dp[j] + 1);
				}
			}
		}
		return Arrays.stream(dp).max().getAsInt();
	}
}

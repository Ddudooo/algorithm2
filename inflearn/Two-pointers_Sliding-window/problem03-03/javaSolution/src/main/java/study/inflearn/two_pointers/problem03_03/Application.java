package study.inflearn.two_pointers.problem03_03;

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
		int[] conditional = Arrays.stream(br.readLine().trim().split(" "))
			.mapToInt(Integer::parseInt).toArray();
		int n = conditional[0];
		int k = conditional[1];
		int[] inputs = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int answer = app.solution(inputs, k);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int[] inputs, int k) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i + k <= inputs.length; i++) {
			int sum = 0;
			for (int j = i; j < i + k; j++) {
				sum += inputs[j];
			}
			if (max < sum) {
				max = sum;
			}
		}
		return max;
	}
}
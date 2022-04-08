package study.inflearn.array.problem02_04;

import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String answer = Arrays.stream(app.solution(n)).mapToObj(String::valueOf).collect(
			Collectors.joining(" "));

		bw.write(answer);
		bw.flush();
		bw.close();
		br.close();
	}

	public int[] solution(int n) {
		int[] result = new int[n];
		for (int i = 0; i < min(2, n); i++) {
			result[i] = 1;
		}
		if (n > 2) {
			for (int j = 2; j < n; j++) {
				result[j] = result[j - 1] + result[j - 2];
			}
		}
		return result;
	}

	private int fibo(int n) {
		if (n <= 1) {
			return n;
		}
		return fibo(n - 2) + fibo(n - 1);
	}
}
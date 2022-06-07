package study.inflearn.dp.problem10_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		int answer = app.solution(n);

		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int n) {
		if (n <= 2) {
			return n;
		}
		int[] floor = new int[n + 1];
		floor[0] = 0;
		floor[1] = 1;
		floor[2] = 2;
		for (int i = 3; i <= n; i++) {
			floor[i] = floor[i - 1] + floor[i - 2];
		}
		return floor[n];
	}
}

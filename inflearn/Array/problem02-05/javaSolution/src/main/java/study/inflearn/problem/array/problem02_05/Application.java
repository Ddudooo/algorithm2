package study.inflearn.problem.array.problem02_05;

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
		int n = Integer.parseInt(br.readLine());
		int answer = app.solution(n);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int n) {
		boolean[] checks = new boolean[n + 1];
		checks[0] = checks[1] = true;
		int answer = 0;
		for (int i = 2; i <= n; i++) {
			if (!checks[i]) {
				answer++;
				for (int j = i; j <= n; j += i) {
					checks[j] = true;
				}
			}
		}
		return answer;
	}
}
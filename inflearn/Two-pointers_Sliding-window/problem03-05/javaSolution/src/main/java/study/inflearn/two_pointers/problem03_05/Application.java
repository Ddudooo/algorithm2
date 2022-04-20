package study.inflearn.two_pointers.problem03_05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.IntStream;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		bw.write(String.format("%d", app.solution(n)));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int n) {
		int result = 0;
		for (int i = 2; i < n / 2; i++) {
			int sum = IntStream.range(1, i).sum();
			int remain = n - sum;
			if (remain <= 0) {
				break;
			}
			if (remain % i == 0) {
				result++;
			}
		}
		return result;
	}
}
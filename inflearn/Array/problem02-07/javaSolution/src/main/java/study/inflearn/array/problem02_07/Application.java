package study.inflearn.array.problem02_07;

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
		int n = Integer.parseInt(br.readLine());
		int[] solved = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int answer = app.solution(solved);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int[] solves) {
		int sum = 0;
		int count = 0;
		for (int solved : solves) {
			if (solved == 1) {
				sum += count++;
			} else {
				sum += count;
				count = 0;
			}
		}
		sum += count;
		return sum;
	}
}
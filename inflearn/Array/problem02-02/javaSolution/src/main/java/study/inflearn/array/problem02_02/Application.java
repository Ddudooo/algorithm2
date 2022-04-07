package study.inflearn.array.problem02_02;

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
		String input = br.readLine();
		int[] student = Arrays.stream(input.trim().split(" ")).mapToInt(Integer::valueOf).toArray();
		bw.write(String.format("%d", app.solution(student)));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int[] students) {
		int previous = students[0];
		int count = 1;
		for (int i = 1; i < students.length; i++) {
			int cur = students[i];
			if (cur > previous) {
				count++;
				previous = cur;
			}
		}
		return count;
	}
}
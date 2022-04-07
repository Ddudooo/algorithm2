package study.inflearn.array.problem02_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::valueOf)
			.toArray();
		int[] B = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::valueOf)
			.toArray();
		List<String> answer = app.solution(A, B, n);
		bw.write(String.join("\n", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public List<String> solution(int[] A, int[] B, int n) {
		List<String> results = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int curA = A[i];
			int curB = B[i];
			results.add(battle(curA, curB));
		}
		return results;
	}

	private String battle(int A, int B) {
		if ((A == 1 && B == 3) || (A == 2 && B == 1) || (A == 3 && B == 2)) {
			return "A";
		}
		if ((B == 1 && A == 3) || (B == 2 && A == 1) || (B == 3 && A == 2)) {
			return "B";
		}
		return "D";
	}
}
package study.inflearn.dfs.problem08_07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] conditions = Arrays.stream(br.readLine().trim().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		int answer = app.solution(conditions[0], conditions[1]);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int n, int r) {
		int[] arr = IntStream.range(1, n).toArray();
		return comb(arr, n, r);
	}

	private int comb(int[] arr, int n, int r) {
		if (r == 0 || n == r) {
			return 1;
		} else {
			return comb(arr, n - 1, r - 1) + comb(arr, n - 1, r);
		}
	}
}

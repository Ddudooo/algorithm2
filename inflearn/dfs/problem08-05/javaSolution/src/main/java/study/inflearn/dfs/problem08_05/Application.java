package study.inflearn.dfs.problem08_05;

import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

	private int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		int[] inputs = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int m = Integer.parseInt(br.readLine().trim());
		int answer = app.solution(inputs, m);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int[] currencies, int target) {
		answer = Integer.MAX_VALUE;
		List<Integer> ints = Arrays.stream(currencies).boxed().collect(Collectors.toList());
		Collections.sort(ints, Collections.reverseOrder());
		int[] sorted = ints.stream().mapToInt(Integer::intValue).toArray();
		dfs(sorted, target, 0, 0);
		return answer;
	}

	public void dfs(int[] currencies, int target, int count, int sum) {
		if (count > answer) {
			return;
		}
		if (target == sum) {
			answer = min(count, answer);
			return;
		} else if (target < sum) {
			return;
		}
		for (int currency : currencies) {
			int nextSum = sum + currency;
			if (nextSum <= target) {
				dfs(currencies, target, count + 1, nextSum);
			}
		}
	}
}

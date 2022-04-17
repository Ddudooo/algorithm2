package study.inflearn.two_pointers.problem03_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arrayA = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int m = Integer.parseInt(br.readLine());
		int[] arrayB = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int[] answer = app.solution(arrayA, arrayB);
		String answerStr = Arrays.stream(answer).mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));
		bw.write(answerStr);
		bw.flush();
		bw.close();
		br.close();
	}

	public int[] solution(int[] arrayA, int[] arrayB) {
		Set<Integer> result = new LinkedHashSet<>();
		int[] sortedA = Arrays.stream(arrayA).sorted().toArray();
		int[] sortedB = Arrays.stream(arrayB).sorted().toArray();
		int n = arrayA.length;
		int m = arrayB.length;
		int aIdx = 0;
		int bIdx = 0;
		while (aIdx < n && bIdx < m) {
			int a = sortedA[aIdx];
			int b = sortedB[bIdx];
			if (a == b) {
				result.add(a);
				aIdx++;
				bIdx++;
			}
			if (a > b) {
				bIdx++;
			}
			if (a < b) {
				aIdx++;
			}
		}

		return result.stream().mapToInt(Integer::valueOf).toArray();
	}
}
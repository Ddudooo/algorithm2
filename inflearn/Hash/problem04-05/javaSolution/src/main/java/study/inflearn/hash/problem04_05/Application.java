package study.inflearn.hash.problem04_05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] conditions = Arrays.stream(br.readLine().trim().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		int[] inputs = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		bw.write(String.format("%d", app.solution(inputs, conditions[1])));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int[] inputs, int k) {
		TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
		int result = 0;
		int sum = 0;
		for (int i = 0; i < inputs.length; i++) {
			sum += inputs[i];
			for (int j = i + 1; j < inputs.length; j++) {
				sum += inputs[j];
				for (int l = j + 1; l < inputs.length; l++) {
					sum += inputs[l];
					set.add(sum);
					sum -= inputs[l];
				}
				sum -= inputs[j];
			}
			sum -= inputs[i];
		}

		while (!set.isEmpty() && k > 0) {
			result = set.pollFirst();
			k--;
		}
		return k > 0 ? -1 : result;
	}
}
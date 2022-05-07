package study.inflearn.sort.problem06_06;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		int[] inputs = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int[] results = app.solution(inputs);
		String answer = Arrays.stream(results).mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));
		bw.write(answer);
		bw.flush();
		bw.close();
		br.close();
	}

	public int[] solution(int[] inputs) {
		int[] results = new int[2];
		int last = inputs.length - 1;
		int preValue = inputs[last];
		for (int i = last - 1; i >= 0; i--) {
			if (preValue < inputs[i]) {
				results[1] = max(i + 2, results[1]);
				results[0] = i + 1;
				inputs[i + 1] = inputs[i];
				inputs[i] = preValue;
			}
			preValue = inputs[i];
		}
		return results;
	}
}

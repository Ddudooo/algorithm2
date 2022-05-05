package study.inflearn.sort.problem06_02;

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
		int n = Integer.parseInt(br.readLine());
		int[] inputs = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int[] sorted = app.solution(inputs);
		String answer = Arrays.stream(sorted).mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));
		bw.write(answer);
		bw.flush();
		bw.close();
		br.close();
	}

	public int[] solution(int[] ints) {
		for (int i = ints.length; i >= 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				int current = ints[j];
				int compare = ints[j + 1];
				if (current > compare) {
					ints[j + 1] = current;
					ints[j] = compare;
				}
			}
		}
		return ints;
	}
}

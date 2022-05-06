package study.inflearn.sort.problem06_03;

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
		for (int i = 1; i < ints.length; i++) {
			int current = ints[i];
			int j = i - 1;
			for (; j >= 0 && ints[j] > current; j--) {
				ints[j + 1] = ints[j];
			}
			ints[j + 1] = current;
		}
		return ints;
	}

}

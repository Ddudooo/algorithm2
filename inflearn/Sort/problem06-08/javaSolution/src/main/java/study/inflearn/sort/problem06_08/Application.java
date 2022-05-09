package study.inflearn.sort.problem06_08;

import static java.lang.Math.floorDiv;

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
		int[] conditions = Arrays.stream(br.readLine().trim().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		int[] inputs = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int result = app.solution(inputs, conditions[1]);
		bw.write(String.format("%d", result));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int[] inputs, int m) {
		Arrays.sort(inputs);
		int start = 0;
		int end = inputs.length - 1;
		int mid = floorDiv((start + end), 2);
		while (start <= end) {
			mid = floorDiv((start + end), 2);
			if (inputs[mid] == m) {
				return mid + 1;
			} else if (inputs[mid] < m) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return mid;
	}
}

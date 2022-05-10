package study.inflearn.sort.problem06_09;

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
		int answer = app.solution(inputs, conditions[1]);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int[] input, int div) {
		int result = 0;
		int start = Arrays.stream(input).max().getAsInt();
		int end = Arrays.stream(input).sum();
		int mid = floorDiv((start + end), 2);
		while (start <= end) {
			mid = floorDiv((start + end), 2);
			int split = splitIntAryBySum(input, mid);
			if (split <= div) {
				result = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}

	public int splitIntAryBySum(int[] inputs, int maxSum) {
		int result = 0;
		int count = 1;
		for (int input : inputs) {
			if (result + input > maxSum) {
				count++;
				result = input;
			} else {
				result += input;
			}
		}
		return count;
	}
}

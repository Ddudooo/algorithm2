package study.inflearn.two_pointers.problem03_04;

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
			.mapToInt(Integer::parseInt).toArray();
		int[] inputs = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int answer = app.solution(inputs, conditions[1]);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int[] inputs, int m) {
		int result = 0;
		int length = inputs.length;
		int l = 0, r = 0, sum = 0;
		sum += inputs[l];
		while (l < length) {
			if (sum == m) {
				sum -= inputs[l++];
				result++;
			}

			if (l == r) {
				if (r == length - 1) {
					break;
				}
				sum += inputs[++r];
			}

			if (sum < m) {
				if (r == length - 1) {
					break;
				}
				sum += inputs[++r];
			} else {
				sum -= inputs[l++];
			}
		}
		return result;
	}
}
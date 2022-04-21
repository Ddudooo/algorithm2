package study.inflearn.two_pointers.problem03_06;

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

	public int solution(int[] inputs, int k) {
		int maxLength = 0;
		int lt = 0, rt = 0, sum = 0, usable = k;
		while (rt < inputs.length) {
			if (inputs[rt] == 1) {
				sum++;
				rt++;
			} else {
				if (usable > 0) {
					usable--;
					rt++;
					sum++;
				} else {
					int l = inputs[lt++];
					if (l == 0) {
						usable++;
					}
					sum--;
				}
			}
			if (sum > maxLength) {
				maxLength = sum;
			}
		}
		return maxLength;
	}
}
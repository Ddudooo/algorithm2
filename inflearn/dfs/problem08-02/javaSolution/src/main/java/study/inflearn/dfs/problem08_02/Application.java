package study.inflearn.dfs.problem08_02;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Application {

	private int answer = 0;

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] conditions = Arrays.stream(br.readLine().trim().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		int[] inputs = new int[conditions[1]];
		for (int i = 0; i < conditions[1]; i++) {
			inputs[i] = Integer.parseInt(br.readLine().trim());
		}

		int answer = app.solution(inputs, conditions[0]);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int[] inputs, int limitWeight) {
		carry(inputs, limitWeight, 0, 0);
		return answer;
	}

	public void carry(int[] inputs, int limit, int idx, int result) {
		if (inputs.length == idx) {
			if (limit >= result) {
				answer = max(result, answer);
			}
			return;
		}

		carry(inputs, limit, idx + 1, result + inputs[idx]);
		carry(inputs, limit, idx + 1, result);
	}
}

package study.inflearn.sort.problem06_10;

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

	public int solution(int[] inputs, int c) {
		int result = 0;
		Arrays.sort(inputs);
		int start = 1;
		int end = inputs[inputs.length - 1];
		while (start <= end) {
			int mid = (start + end) / 2;
			if (count(inputs, mid) >= c) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return result;
	}

	/**
	 * 마굿간 순회하며 최소 거리보다 클때 말을 넣을때 말 갯수
	 *
	 * @param inputs 마굿간
	 * @param range 최소거리
	 * @return 최소거리가 range일때 말을 넣을 수 있는 최대값
	 */
	public int count(int[] inputs, int range) {
		int cnt = 1;
		int end = inputs[0];
		for (int input : inputs) {
			if (input - end >= range) {
				cnt++;
				end = input;
			}
		}
		return cnt;
	}
}

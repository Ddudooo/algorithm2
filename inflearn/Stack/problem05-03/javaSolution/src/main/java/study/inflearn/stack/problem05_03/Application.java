package study.inflearn.stack.problem05_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
				.toArray();
		}
		int m = Integer.parseInt(br.readLine());
		int[] moves = new int[m];
		moves = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int answer = app.solution(map, moves);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int[][] map, int[] moves) {
		int result = 0;
		Stack<Integer> bracket = new Stack<>();
		for (int position : moves) {
			int picked = pick(map, position - 1);
			if (picked != 0) {
				if (!bracket.isEmpty() && bracket.peek() == picked) {
					bracket.pop();
					result += 2;
				} else {
					bracket.push(picked);
				}
			}
		}
		return result;
	}

	private int pick(int[][] map, int position) {
		for (int i = 0; i < map.length; i++) {
			if (map[i][position] != 0) {
				int picked = map[i][position];
				map[i][position] = 0;
				return picked;
			}
		}
		return 0;
	}
}

package study.inflearn.array.problem02_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n + 2][n + 2];
		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().trim().split(" ");
			for (int j = 0; j < n; j++) {
				map[i + 1][j + 1] = Integer.parseInt(split[j]);
			}
		}
		int answer = app.solution(map, n);

		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int[][] map, int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (isTop(map, i, j)) {
					count++;
				}
			}
		}
		return count;
	}

	private boolean isTop(int[][] map, int x, int y) {
		return map[x][y] > Collections.max(
			Arrays.asList(map[x][y - 1], map[x][y + 1], map[x - 1][y], map[x + 1][y]));
	}
}
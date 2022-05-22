package study.inflearn.dfs.problem08_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Application {

	private final int[] dx = {1, 0, -1, 0};
	private final int[] dy = {0, 1, 0, -1};
	private int answer = 0;

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[][] check = new boolean[8][8];
		for (int i = 0; i < 7; i++) {
			String[] split = br.readLine().trim().split(" ");
			for (int j = 0; j < 7; j++) {
				boolean value = Integer.parseInt(split[j]) == 1;
				check[i + 1][j + 1] = value;
			}
		}
		int answer = app.solution(check);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(boolean[][] check) {
		answer = 0;
		for (int i = 0; i < 8; i++) {
			check[0][i] = true;
			check[i][0] = true;
		}
		check[1][1] = true;
		dfs(1, 1, check);
		return answer;
	}

	private void dfs(int x, int y, boolean[][] check) {
		if (x == 7 && y == 7) {
			answer++;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (nextX >= 1 && nextX <= 7 && nextY >= 1 && nextY <= 7 && !check[nextX][nextY]) {
				check[nextX][nextY] = true;
				dfs(nextX, nextY, check);
				check[nextX][nextY] = false;
			}
		}
	}
}

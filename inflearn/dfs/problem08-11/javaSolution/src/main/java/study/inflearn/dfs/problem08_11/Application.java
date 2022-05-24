package study.inflearn.dfs.problem08_11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Application {

	private final int[] dx = {1, 0, -1, 0};
	private final int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[][] map = new boolean[7][7];
		for (int i = 0; i < 7; i++) {
			String[] readLine = br.readLine().trim().split(" ");
			for (int j = 0; j < 7; j++) {
				map[i][j] = Integer.parseInt(readLine[j]) == 1;
			}
		}
		int answer = app.solution(map);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(boolean[][] map) {
		Queue<Point> queue = new LinkedList<>();
		map[0][0] = true;
		queue.add(new Point(0, 0, 0));
		while (!queue.isEmpty()) {
			Point current = queue.poll();
			if (current.x == 6 && current.y == 6) {
				return current.duration;
			}
			for (int i = 0; i < 4; i++) {
				int nextX = current.x + dx[i];
				int nextY = current.y + dy[i];
				if (nextX >= 0 && nextX < 7 && nextY >= 0 && nextY < 7
					&& !map[nextX][nextY]) {
					map[nextX][nextY] = true;
					queue.add(new Point(nextX, nextY, current.duration + 1));
				}
			}
		}
		return -1;
	}
}

class Point {

	final int x;
	final int y;
	final int duration;

	Point(int x, int y, int duration) {
		this.x = x;
		this.y = y;
		this.duration = duration;
	}
}
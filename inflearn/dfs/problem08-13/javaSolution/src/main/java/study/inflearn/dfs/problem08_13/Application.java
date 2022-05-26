package study.inflearn.dfs.problem08_13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Application {

	private final int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
	private final int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};
	private int maxX;
	private int maxY;

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
				.toArray();
		}
		int answer = app.solution(n, map);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int n, int[][] map) {
		maxX = n;
		maxY = n;
		int result = 0;
		Point point = checkRemainLand(map);
		while (point.x != -1 && point.y != -1) {
			result++;
			searchLand(map, point.x, point.y);
			point = checkRemainLand(map);
		}
		return result;
	}

	private void searchLand(int[][] map, int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		map[x][y] = 0;
		queue.add(new Point(x, y));
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			for (int i = 0; i < 8; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx >= 0 && nx < maxX && ny >= 0 && ny < maxY && map[nx][ny] == 1) {
					map[nx][ny] = 0;
					queue.add(new Point(nx, ny));
				}
			}
		}
	}

	private Point checkRemainLand(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1) {
					return new Point(i, j);
				}
			}
		}
		return new Point(-1, -1);
	}
}

class Point {

	final int x;
	final int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
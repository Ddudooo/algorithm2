package study.inflearn.dfs.problem08_12;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Application {

	private final int[] dx = {1, 0, -1, 0};
	private final int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] conditions = Arrays.stream(br.readLine().trim().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		
		int maxY = conditions[0];
		int maxX = conditions[1];
		int[][] map = new int[maxX][maxY];
		for (int i = 0; i < maxX; i++) {
			String input = br.readLine();
			map[i] = Arrays.stream(input.trim().split(" ")).mapToInt(Integer::parseInt)
				.toArray();
		}
		int answer = app.solution(maxX, maxY, map);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int maxX, int maxY, int[][] map) {
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < maxX; i++) {
			for (int j = 0; j < maxY; j++) {
				if (map[i][j] == 1) {
					queue.add(new Point(i, j));
				}
			}
		}
		int result = -1;
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			result = max(cur.duration, result);
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY
					&& map[nextX][nextY] == 0) {
					map[nextX][nextY] = 1;
					queue.add(new Point(nextX, nextY, cur.duration + 1));
				}
			}
		}
		if (result > 0) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == 0) {
						return -1;
					}
				}
			}
		}
		return result;
	}
}

class Point {

	final int x;
	final int y;

	int duration = 0;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Point(int x, int y, int duration) {
		this.x = x;
		this.y = y;
		this.duration = duration;
	}
}
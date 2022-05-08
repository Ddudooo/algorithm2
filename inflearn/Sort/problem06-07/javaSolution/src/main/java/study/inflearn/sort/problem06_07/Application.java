package study.inflearn.sort.problem06_07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		String[] inputStrs = new String[n];
		for (int i = 0; i < n; i++) {
			inputStrs[i] = br.readLine().trim();
		}
		List<Coordinate> results = app.solution(inputStrs);
		for (Coordinate result : results) {
			bw.write(result.toString());
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public List<Coordinate> solution(String inputs[]) {
		List<Coordinate> inputCoordinates = Arrays.stream(inputs).map(
				(str) -> Arrays.stream(str.trim().split(" ")).mapToInt(Integer::parseInt).toArray())
			.map((pair) -> new Coordinate(pair[0], pair[1]))
			.collect(Collectors.toList());
		Collections.sort(inputCoordinates);
		return inputCoordinates;
	}
}

class Coordinate implements Comparable<Coordinate> {

	private final int x;
	private final int y;

	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return String.format("%d %d\n", this.x, this.y);
	}

	@Override
	public int compareTo(Coordinate o) {
		if (o.x == this.x) {
			return this.y - o.y;
		}
		return this.x - o.x;
	}
}

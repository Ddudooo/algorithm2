package study.inflearn.dfs.problem08_14;

import static java.lang.Math.abs;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] conditions = Arrays.stream(br.readLine().trim().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		int n = conditions[0];
		int m = conditions[1];
		List<Point> houseList = new ArrayList<>();
		List<Point> pizzaList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int[] split = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
				.toArray();
			for (int j = 0; j < n; j++) {
				if (split[j] == 1) {
					houseList.add(new Point(i, j));
				}
				if (split[j] == 2) {
					pizzaList.add(new Point(i, j));
				}
			}
		}
		PizzaSolution pizzaSolution = new PizzaSolution(m, houseList, pizzaList);
		int answer = pizzaSolution.solution();
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}
}

class PizzaSolution {

	private int answer = Integer.MAX_VALUE;
	private final int target;

	private final List<Point> houseList;
	private final List<Point> pizzaList;
	private final int pizzaListSize;
	private final int[] picked;

	PizzaSolution(int target, List<Point> houseList, List<Point> pizzaList) {
		this.target = target;
		this.houseList = houseList;
		this.pizzaList = pizzaList;
		this.pizzaListSize = pizzaList.size();
		this.picked = new int[target];
	}

	public int solution() {
		answer = Integer.MAX_VALUE;
		dfs(0, 0);
		return answer;
	}

	private void dfs(int idx, int start) {
		if (idx == target) {
			int sum = 0;
			for (Point house : houseList) {
				int distance = Integer.MAX_VALUE;
				for (int pizzaIdx : picked) {
					Point pizza = pizzaList.get(pizzaIdx);
					distance = min(distance, abs(house.x - pizza.x) + abs(house.y - pizza.y));
				}
				sum += distance;
				if (sum >= answer) {
					return;
				}
			}
			answer = min(answer, sum);
			return;
		} else {
			for (int i = start; i < pizzaListSize; i++) {
				picked[idx] = i;
				dfs(idx + 1, i + 1);
			}
		}
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
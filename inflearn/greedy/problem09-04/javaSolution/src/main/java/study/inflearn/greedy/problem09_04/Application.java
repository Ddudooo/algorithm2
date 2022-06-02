package study.inflearn.greedy.problem09_04;

import static java.util.Collections.reverseOrder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		Concert[] concerts = new Concert[n];
		for (int i = 0; i < n; i++) {
			int[] input = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
				.toArray();
			concerts[i] = new Concert(input[0], input[1]);
		}
		int answer = app.solution(concerts);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(Concert[] concerts) {
		int maxDay = Arrays.stream(concerts).mapToInt((concert) -> concert.day).max().getAsInt();
		PriorityQueue<Integer> queue = new PriorityQueue<>(reverseOrder());
		int len = concerts.length;
		Arrays.sort(concerts);
		int result = 0;
		int j = 0;
		for (int i = maxDay; i >= 1; i--) {
			for (; j < len; j++) {
				if (concerts[j].day < i) {
					break;
				}
				queue.add(concerts[j].pay);
			}
			if (!queue.isEmpty()) {
				result += queue.poll();
			}
		}
		return result;
	}
}

class Concert implements Comparable<Concert> {

	final int pay;
	final int day;

	Concert(int pay, int day) {
		this.pay = pay;
		this.day = day;
	}

	@Override
	public String toString() {
		return "Concert{" +
			"pay=" + pay +
			", day=" + day +
			'}';
	}

	@Override
	public int compareTo(Concert o) {

		if (this.day > o.day) {
			return -1;
		} else if (this.day < o.day) {
			return 1;
		}

		return 0;
	}
}
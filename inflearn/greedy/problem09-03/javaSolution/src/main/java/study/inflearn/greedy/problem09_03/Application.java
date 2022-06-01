package study.inflearn.greedy.problem09_03;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		Guest[] guests = new Guest[n];
		for (int i = 0; i < n; i++) {
			int[] conditions = Arrays.stream(br.readLine().trim().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			guests[i] = new Guest(conditions[0], conditions[1]);
		}
		int answer = app.solution(guests);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(Guest[] guests) {
		List<Guest> guestList = Arrays.asList(guests);
		int result = 0;
		for (int time = 0; time <= 72; time++) {
			int currentTime = time;
			int count = (int) guestList.stream()
				.filter(guest -> guest.start <= currentTime && guest.end > currentTime)
				.count();
			result = max(result, count);
		}

		return result;
	}
}

class Guest {

	final int start;
	final int end;

	Guest(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

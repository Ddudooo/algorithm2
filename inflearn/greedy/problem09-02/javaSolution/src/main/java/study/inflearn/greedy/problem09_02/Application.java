package study.inflearn.greedy.problem09_02;

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
		Meeting[] meetings = new Meeting[n];
		for (int i = 0; i < n; i++) {
			int[] conditions = Arrays.stream(br.readLine().trim().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			meetings[i] = new Meeting(conditions[0], conditions[1]);
		}
		int answer = app.solution(meetings);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(Meeting[] meetings) {
		PriorityQueue<Meeting> reservation = new PriorityQueue<>();
		reservation.addAll(Arrays.asList(meetings));
		int currentTime = 0;
		int result = 0;
		while (!reservation.isEmpty()) {
			Meeting currentMeeting = reservation.poll();
			if (currentMeeting.start >= currentTime) {
				result++;
				currentTime = currentMeeting.end;
			}
		}
		return result;
	}
}

class Meeting implements Comparable<Meeting> {

	final int start;
	final int end;

	private final int duration;

	Meeting(int start, int end) {
		this.start = start;
		this.end = end;
		this.duration = end - start;
	}

	@Override
	public int compareTo(Meeting o) {
		if (this.end > o.end) {
			return 1;
		} else if (this.start < o.end) {
			return -1;
		}
		if (this.duration > o.duration) {
			return 1;
		} else if (this.duration < o.duration) {
			return -1;
		}
		if (this.start > o.start) {
			return 1;
		} else if (this.start < o.start) {
			return -1;
		}
		return 0;
	}
}

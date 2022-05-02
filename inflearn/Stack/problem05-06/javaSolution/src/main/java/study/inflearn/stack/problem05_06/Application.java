package study.inflearn.stack.problem05_06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] inputs = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int answer = app.solution(inputs[0], inputs[1]);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int n, int k) {
		Queue<Integer> queue = new LinkedList<>();
		IntStream.range(1, n + 1).forEach(queue::add);
		int count = 0;
		while (queue.size() > 1) {
			Integer poll = queue.poll();
			count++;
			if (count != k) {
				queue.add(poll);
			} else {
				count = 0;
			}
		}
		return queue.poll();
	}

}

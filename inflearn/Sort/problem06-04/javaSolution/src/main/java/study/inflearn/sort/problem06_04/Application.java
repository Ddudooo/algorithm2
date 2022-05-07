package study.inflearn.sort.problem06_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] conditions = Arrays.stream(br.readLine().trim().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		int[] inputs = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int[] results = app.solution(inputs, conditions[0]);
		String answer = Arrays.stream(results).mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));
		bw.write(answer);
		bw.flush();
		bw.close();
		br.close();
	}

	public int[] solution(int[] inputs, int s) {
		Queue<Integer> cache = new LinkedList<>();
		for (int input : inputs) {
			if (cache.contains(input)) {
				cache.remove(input);
				cache.add(input);
			} else {
				cache.add(input);
			}

			if (cache.size() > s) {
				cache.poll();
			}
		}
		List<Integer> results = new ArrayList<>(cache);
		Collections.reverse(results);
		return results.stream().mapToInt(Integer::intValue).toArray();
	}
}

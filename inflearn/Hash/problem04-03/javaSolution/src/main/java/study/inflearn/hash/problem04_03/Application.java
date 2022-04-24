package study.inflearn.hash.problem04_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		int[] answer = app.solution(inputs, conditions[1]);
		String answerStr = Arrays.stream(answer).mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));
		bw.write(answerStr);
		bw.flush();
		bw.close();
		br.close();
	}

	public int[] solution(int[] inputs, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			int key = inputs[i];
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		int lt = 0;
		for (int rt = n - 1; rt < inputs.length; rt++) {
			map.put(inputs[rt], map.getOrDefault(inputs[rt], 0) + 1);
			result.add(map.size());
			map.put(inputs[lt], map.get(inputs[lt]) - 1);
			if (map.get(inputs[lt]) == 0) {
				map.remove(inputs[lt]);
			}
			lt++;
		}

		return result.stream().mapToInt(Integer::valueOf).toArray();
	}
}
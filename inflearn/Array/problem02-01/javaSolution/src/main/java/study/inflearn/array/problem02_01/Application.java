package study.inflearn.array.problem02_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int[] intAry = new int[n];
		for (int i = 0; i < n; i++) {
			intAry[i] = Integer.parseInt(st.nextToken());
		}
		int[] answers = app.solution(intAry);
		String answerStr = Arrays.stream(answers).mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));
		bw.write(answerStr);
		bw.flush();
		bw.close();
		br.close();
	}

	public int[] solution(int[] inputAry) {
		List<Integer> result = new ArrayList<>();
		int pre = inputAry[0];
		result.add(pre);
		for (int i = 1; i < inputAry.length; i++) {
			int cur = inputAry[i];
			if (cur > pre) {
				result.add(cur);
			}
			pre = cur;
		}
		return result.stream().mapToInt(i -> i).toArray();
	}
}
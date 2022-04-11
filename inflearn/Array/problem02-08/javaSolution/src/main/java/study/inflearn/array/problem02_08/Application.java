package study.inflearn.array.problem02_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int[] answer = app.solution(scores);
		String answerStr = Arrays.stream(answer).mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));
		bw.write(answerStr);
		bw.flush();
		bw.close();
		br.close();
	}

	public int[] solution(int[] scores) {
		int length = scores.length;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			int count = 1;
			for (int score : scores) {
				if (scores[i] < score) {
					count++;
				}
			}
			result[i] = count;
		}
		return result;
	}
}

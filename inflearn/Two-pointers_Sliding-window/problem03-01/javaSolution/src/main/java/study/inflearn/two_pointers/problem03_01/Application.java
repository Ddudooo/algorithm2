package study.inflearn.two_pointers.problem03_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arrayA = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int m = Integer.parseInt(br.readLine());
		int[] arrayB = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		int[] answers = app.mergeArraysOrderByASC(arrayA, arrayB);
		String answerStr = Arrays.stream(answers).mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));
		bw.write(answerStr);
		bw.flush();
		bw.close();
		br.close();
	}

	public int[] mergeArraysOrderByASC(int[] arrayA, int[] arrayB) {
		List<Integer> mergedSet = new ArrayList<>();
		mergedSet.addAll(Arrays.stream(arrayA).boxed().collect(Collectors.toList()));
		mergedSet.addAll(Arrays.stream(arrayB).boxed().collect(Collectors.toList()));
		return Arrays.stream(mergedSet.stream().mapToInt(Integer::valueOf).toArray()).sorted()
			.toArray();
	}
}
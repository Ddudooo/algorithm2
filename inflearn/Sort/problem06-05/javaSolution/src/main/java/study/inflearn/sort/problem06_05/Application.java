package study.inflearn.sort.problem06_05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		int[] inputs = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt)
			.toArray();
		boolean answer = app.solution(inputs);
		bw.write(answer ? "U" : "D");
		bw.flush();
		bw.close();
		br.close();
	}

	public boolean solution(int[] inputs) {
		Set<Integer> set = Arrays.stream(inputs).boxed().collect(Collectors.toSet());
		return set.size() == inputs.length;
	}
}

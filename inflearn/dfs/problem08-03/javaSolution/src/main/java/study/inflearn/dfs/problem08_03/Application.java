package study.inflearn.dfs.problem08_03;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

	private int answer = 0;

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] conditions = Arrays.stream(br.readLine().trim().split(" "))
			.mapToInt(Integer::parseInt).toArray();
		List<Problem> problemList = new ArrayList<>();
		for (int i = 0; i < conditions[0]; i++) {
			int[] inputs = Arrays.stream(br.readLine().trim().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			problemList.add(new Problem(inputs[0], inputs[1]));
		}
		app.solution(problemList, conditions[1]);
		bw.write(String.format("%d", app.answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(List<Problem> problemList, int limit) {
		answer = 0;
		dfs(problemList, limit, 0, 0, 0);
		return answer;
	}

	public void dfs(List<Problem> problemList, int limit, int idx, int totalDuration, int sum) {
		if (idx == problemList.size()) {
			answer = max(sum, answer);
			return;
		}
		Problem solvedProblem = problemList.get(idx);
		if (solvedProblem.getDuration() + totalDuration <= limit) {
			dfs(problemList, limit, idx + 1, totalDuration + solvedProblem.getDuration(),
				sum + solvedProblem.getScore());
		}
		dfs(problemList, limit, idx + 1, totalDuration, sum);
	}
}

class Problem {

	private final int score;
	private final int duration;

	Problem(int score, int duration) {
		this.score = score;
		this.duration = duration;
	}

	public int getScore() {
		return score;
	}

	public int getDuration() {
		return duration;
	}
}
package study.inflearn.string.problem01_10;

import static java.lang.Math.min;

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
		String input = br.readLine();
		String[] split = input.split(" ");
		String s = split[0];
		char c = split[1].charAt(0);
		int[] answer = app.solution(s, c);
		String result = Arrays.stream(answer)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));
		bw.write(result);
		bw.flush();
		bw.close();
		br.close();
	}

	public int[] solution(String s, char t) {
		int[] leftDistance = distanceLeftPosition(s, t);
		int[] rightDistance = distanceRightPosition(s, t);
		int maxLength = s.length();
		int[] result = new int[maxLength];
		for (int i = 0; i < maxLength; i++) {
			result[i] = min(leftDistance[i], rightDistance[i]);
		}
		return result;
	}

	private int[] distanceLeftPosition(String s, char t) {
		int maxLength = s.length();
		int[] leftDistance = new int[maxLength];
		int currentDistance = maxLength;
		for (int i = 0; i < maxLength; i++) {
			if (s.charAt(i) == t) {
				currentDistance = 0;
			}
			leftDistance[i] = currentDistance++;
		}
		return leftDistance;
	}

	private int[] distanceRightPosition(String s, char t) {
		int maxLength = s.length();
		int[] rightDistance = new int[maxLength];
		int currentDistance = maxLength;
		for (int i = 0; i < maxLength; i++) {
			if (s.charAt(maxLength - 1 - i) == t) {
				currentDistance = 0;
			}
			rightDistance[maxLength - 1 - i] = currentDistance++;
		}
		return rightDistance;
	}
}
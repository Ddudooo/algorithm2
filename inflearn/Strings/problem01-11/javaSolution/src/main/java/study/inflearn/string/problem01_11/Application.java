package study.inflearn.string.problem01_11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		bw.write(app.solution(input));
		bw.flush();
		bw.close();
		br.close();
	}

	public String solution(String input) {
		char[] chars = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		char previousChar = chars[0];
		sb.append(previousChar);
		int continuedCount = 1;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == previousChar) {
				continuedCount++;
			} else {
				if (continuedCount > 1) {
					sb.append(continuedCount);
				}
				sb.append(chars[i]);
				previousChar = chars[i];
				continuedCount = 1;
			}
		}
		if (continuedCount > 1) {
			sb.append(continuedCount);
		}
		return sb.toString();
	}
}
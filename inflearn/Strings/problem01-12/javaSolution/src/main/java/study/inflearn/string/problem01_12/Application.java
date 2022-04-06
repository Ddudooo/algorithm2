package study.inflearn.string.problem01_12;

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
		String maxChar = br.readLine();
		String input = br.readLine();
		bw.write(app.solution(input));
		bw.flush();
		bw.close();
		br.close();

	}

	public String solution(String input) {
		String digitStr = input.replaceAll("#", "1").replaceAll("\\*", "0").trim();
		String[] split = digitStr.split("(?<=\\G.{7})");
		StringBuilder sb = new StringBuilder();
		for (String binaryStr : split) {
			int binary = Integer.parseInt(binaryStr, 2);
			sb.append((char) binary);
		}
		return sb.toString();
	}

}
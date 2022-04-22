package study.inflearn.hash.problem04_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		char[] votes = br.readLine().trim().toCharArray();
		bw.write(String.format("%c", app.solution(votes)));
		bw.flush();
		bw.close();
		br.close();
	}

	public char solution(char[] votes) {
		Arrays.sort(votes);
		String[] splitBySameChars = String.valueOf(votes).split("(?<=(.))(?!\\1)");
		Arrays.sort(splitBySameChars, Comparator.comparing(String::length).reversed());
		return splitBySameChars[0].charAt(0);
	}
}
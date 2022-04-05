package study.inflearn.string.problem01_08;

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
		bw.write(app.solution(input) ? "YES" : "NO");
		bw.flush();
		br.close();
		bw.close();
	}

	public boolean solution(String input) {
		String reversedStr = new StringBuilder(input).reverse().toString();
		String notAlphabets = "[^A-Za-z]";
		return reversedStr.replaceAll(notAlphabets, "")
			.equalsIgnoreCase(input.replaceAll(notAlphabets, ""));
	}
}
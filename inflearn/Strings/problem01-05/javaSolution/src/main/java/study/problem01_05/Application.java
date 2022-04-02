package study.problem01_05;

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
		bw.write(app.alphabetReverse(input));
		bw.flush();
		bw.close();
		br.close();
	}

	public String alphabetReverse(String input) {
		char[] alphabets = input.replaceAll("[^A-Za-z]", "").toCharArray();
		int alphabetCnt = alphabets.length;
		char[] chars = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char ch : chars) {
			if (Character.isAlphabetic(ch)) {
				sb.append(alphabets[alphabetCnt - 1]);
				alphabetCnt--;
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}
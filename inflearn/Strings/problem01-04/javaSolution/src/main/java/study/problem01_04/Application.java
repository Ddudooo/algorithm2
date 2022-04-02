package study.problem01_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		List<String> words = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			words.add(br.readLine());
		}

		List<String> reverseWords = words.stream()
			.map(Application::reverseWord)
			.collect(Collectors.toList());

		for (String reverseWord : reverseWords) {
			bw.write(reverseWord);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static String reverseWord(String input) {
		StringBuilder sb = new StringBuilder(input);
		return sb.reverse().toString();
	}
}
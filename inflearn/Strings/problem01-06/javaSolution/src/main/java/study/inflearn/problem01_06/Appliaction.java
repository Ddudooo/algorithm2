package study.inflearn.problem01_06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.LinkedHashSet;
import java.util.Set;

public class Appliaction {

	public static void main(String[] args) throws IOException {
		Appliaction app = new Appliaction();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		bw.write(app.solution(input));
		bw.flush();
		br.close();
		bw.close();
	}

	public String solution(String input) {
		char[] chars = input.toCharArray();
		Set<Character> uniqChars = new LinkedHashSet<>();
		for (char c : chars) {
			uniqChars.add(c);
		}
		return uniqChars.stream().collect(StringWriter::new, StringWriter::write, (swl, swr) -> {
			swl.write(swr.toString());
		}).toString();
	}
}
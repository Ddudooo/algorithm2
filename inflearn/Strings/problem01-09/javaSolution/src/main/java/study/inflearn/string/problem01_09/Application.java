package study.inflearn.string.problem01_09;

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
		bw.write(String.format("%d", app.solution(input)));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(String input) {
		String numericStr = input.replaceAll("[^0-9]", "");
		return Integer.parseInt(numericStr);
	}
}
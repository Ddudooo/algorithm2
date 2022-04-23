package study.inflearn.hash.problem04_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String inputA = br.readLine().trim();
		String inputB = br.readLine().trim();
		boolean checkedAnagram = app.isAnagram(inputA, inputB);
		bw.write(checkedAnagram ? "YES" : "NO");
		bw.flush();
		bw.close();
		br.close();
	}


	public boolean isAnagram(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		char[] aChars = a.toCharArray();
		char[] bChars = b.toCharArray();
		Arrays.sort(aChars);
		Arrays.sort(bChars);

		return Arrays.equals(aChars, bChars);
	}
}
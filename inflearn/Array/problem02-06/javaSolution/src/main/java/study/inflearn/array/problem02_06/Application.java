package study.inflearn.array.problem02_06;

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
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int[] nums = Arrays.stream(input.split(" ")).mapToInt(app::stringToReverseNumber).toArray();
		for (int num : nums) {
			if (app.isPrimeNumber(num)) {
				bw.write(String.format("%d ", num));
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public int stringToReverseNumber(String numberStr) {
		return Integer.parseInt(new StringBuilder(numberStr).reverse().toString());
	}

	public boolean isPrimeNumber(int n) {
		if (n == 1) {
			return false;
		}
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
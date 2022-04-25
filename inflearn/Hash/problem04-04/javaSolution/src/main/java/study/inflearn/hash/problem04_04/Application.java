package study.inflearn.hash.problem04_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine().trim();
		String t = br.readLine().trim();
		bw.write(String.format("%d", app.solution(s, t)));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(String s, String t) {
		int result = 0;
		Map<Character, Integer> countMap = new HashMap<>();
		for (char c : t.toCharArray()) {
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);
		}
		Map<Character, Integer> windowHash = new HashMap<>();
		for (char c : s.substring(0, t.length() - 1).toCharArray()) {
			windowHash.put(c, windowHash.getOrDefault(c, 0) + 1);
		}

		int lt = 0;
		for (int rt = t.length() - 1; rt < s.length(); rt++) {
			char c = s.charAt(rt);
			windowHash.put(c, windowHash.getOrDefault(c, 0) + 1);
			if (countMap.equals(windowHash)) {
				result++;
			}
			char ltc = s.charAt(lt++);
			Integer ltcCount = windowHash.get(ltc);
			if (ltcCount == 1) {
				windowHash.remove(ltc);
			} else {
				windowHash.put(ltc, ltcCount - 1);
			}
		}
		return result;
	}
}
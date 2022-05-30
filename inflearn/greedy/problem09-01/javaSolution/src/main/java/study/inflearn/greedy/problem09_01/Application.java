package study.inflearn.greedy.problem09_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringJoiner;

public class Application {

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		Player[] players = new Player[n];
		for (int i = 0; i < n; i++) {
			int[] conditions = Arrays.stream(br.readLine().trim().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			players[i] = new Player(conditions[0], conditions[1]);
		}
		int answer = app.solution(players);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(Player[] players) {
		int result = players.length;
		for (int i = 0; i < players.length; i++) {
			Player player = players[i];
			if (player.check) {
				result--;
				continue;
			}
			for (int j = 0; j < players.length; j++) {
				if (i == j) {
					continue;
				}
				Player another = players[j];
				if (player.isDrop(another)) {
					result--;
					break;
				}
			}
		}
		return result;
	}
}

class Player {

	final int height;
	final int weight;

	boolean check = false;

	Player(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}

	boolean isDrop(Player another) {
		boolean dropCheck = this.height < another.height && this.weight < another.weight;
		boolean anotherCheck = this.height > another.height && this.weight > another.weight;
		if (anotherCheck) {
			another.check = true;
		}
		this.check = dropCheck;
		return dropCheck;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Player.class.getSimpleName() + "[", "]")
			.add("height=" + height)
			.add("weight=" + weight)
			.toString();
	}
}
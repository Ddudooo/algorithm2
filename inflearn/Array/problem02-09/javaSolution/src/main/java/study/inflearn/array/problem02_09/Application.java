package study.inflearn.array.problem02_09;

import static java.lang.Math.max;

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
		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++) {
			int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
				.toArray();
			board[i] = line;
		}
		int answer = app.solution(board);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int[][] board) {
		return max(getRowAndColumnMax(board), getCrossMax(board));
	}

	private int getRowAndColumnMax(int[][] board) {
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < board.length; i++) {
			int row = 0, column = 0;
			for (int j = 0; j < board[i].length; j++) {
				row += board[i][j];
				column += board[j][i];
			}
			result = max(result, row);
			result = max(result, column);
		}
		return result;
	}

	private int getCrossMax(int[][] board) {
		int result = Integer.MIN_VALUE;
		int leftCross = 0, rightCross = 0;
		for (int i = 0; i < board.length; i++) {
			leftCross += board[i][i];
			rightCross += board[i][board.length - i - 1];
		}
		result = max(leftCross, result);
		result = max(rightCross, result);
		return result;
	}
}
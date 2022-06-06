package study.inflearn.greedy.problem09_07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Application {

	private int[] nodeSet;

	public static void main(String[] args) throws IOException {
		Application app = new Application();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] conditions = Arrays.stream(br.readLine().trim().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		int v = conditions[0]; // 도시 갯수
		int e = conditions[1]; // 도로 갯수
		Node[] nodes = new Node[e];
		for (int i = 0; i < e; i++) {
			int[] inputs = Arrays.stream(br.readLine().trim().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			nodes[i] = new Node(inputs[0], inputs[1], inputs[2]);
		}
		int answer = app.solution(v, nodes);
		bw.write(String.format("%d", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public int solution(int v, Node[] nodes) {
		int result = 0;
		nodeSet = IntStream.range(0, v + 1).toArray();
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.addAll(Arrays.asList(nodes));
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (find(cur.to) != find(cur.from)) {
				union(cur.to, cur.from);
				result += cur.value;
			}
		}
		return result;
	}

	private int find(int value) {
		if (value == nodeSet[value]) {
			return value;
		} else {
			return nodeSet[value] = find(nodeSet[value]);
		}
	}

	private void union(int a, int b) {
		int findA = find(a);
		int findB = find(b);
		if (findA != findB) {
			nodeSet[findA] = findB;
		}
	}
}

class Node implements Comparable<Node> {

	final int to;
	final int from;
	final int value;

	Node(int to, int from, int value) {
		this.to = to;
		this.from = from;
		this.value = value;
	}

	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
	}
}
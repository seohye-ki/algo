import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
	int start, end, weight;

	Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

public class boj1414 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System. in));
		int N = Integer.parseInt(br.readLine());

		List<Edge> edges = new ArrayList<>();
		long totalLength = 0;

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = line.charAt(j);
				int weight = 0;

				if ('a' <= c && c <= 'z') 
					weight = c -'a' + 1;
				else if ('A' <= c && c <= 'Z')
					weight = c - 'A' + 27;

				totalLength += weight;

				if (i != j && weight > 0) {
					edges.add(new Edge(i, j, weight));
				}
			}
		}

		Collections.sort(edges);
		parent = new int[N];
		for (int i = 0; i < N; i++)
			parent[i] = i;

		int usedEdges = 0;
		long mstWeight = 0;

        for (Edge edge : edges) {
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                mstWeight += edge.weight;
                usedEdges++;
            }
        }

		if (usedEdges == N - 1 || N == 1) {
			System.out.println(totalLength - mstWeight);
		} else {
			System.out.println(-1);
		}
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y)
			parent[y] = x;
	}

}

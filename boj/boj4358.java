import java.util.*;
import java.io.*;

public class boj4358 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		int total = 0;
		String line;

		while((line = br.readLine()) != null) {
			if(line.isEmpty()) break;

			treeMap.put(line, treeMap.getOrDefault(line, 0) + 1);
			total++;
		}

		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, Integer> entry : treeMap.entrySet()) {
			String name = entry.getKey();
			int count = entry.getValue();

			double percentage = (double)count * 100 / total;
			sb.append(name).append(" ").append(String.format("%.4f", percentage)).append("\n");
		}
		System.out.print(sb.toString());
	}
}
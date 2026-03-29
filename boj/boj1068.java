import java.util.*;
import java.io.*;

public class boj1068 {
    static List<Integer>[] children;
    static Set<Integer> deleted = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        children = new ArrayList[N];
        for (int i = 0; i < N; i++) children[i] = new ArrayList<>();

        int root = -1;
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == -1) root = i;
            else children[p].add(i);
        }

        int deleteNode = Integer.parseInt(br.readLine().trim());

        Stack<Integer> stack = new Stack<>();
        stack.push(deleteNode);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            deleted.add(node);
            for (int child : children[node]) {
                stack.push(child);
            }
        }

        if (deleted.contains(root)) {
            System.out.println(0);
            return;
        }

        int leafCount = 0;
        for (int node = 0; node < N; node++) {
            if (deleted.contains(node)) continue;

            boolean isLeaf = true;
            for (int child : children[node]) {
                if (!deleted.contains(child)) {
                    isLeaf = false;
                    break;
                }
            }
            if (isLeaf) leafCount++;
        }

        System.out.println(leafCount);
    }
}
import java.util.Scanner;

public class boj16719 {
    static String input;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = sc.next();
        visited = new boolean[input.length()];

        solve(0, input.length() - 1);
    }

    static void solve(int left, int right) {
        if (left > right) return;

        int minIdx = left;
        for (int i = left; i <= right; i++) {
            if (input.charAt(minIdx) > input.charAt(i)) {
                minIdx = i;
            }
        }

        visited[minIdx] = true;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (visited[i]) {
                sb.append(input.charAt(i));
            }
        }
        System.out.println(sb.toString());

        solve(minIdx + 1, right);
        solve(left, minIdx - 1);
    }
}
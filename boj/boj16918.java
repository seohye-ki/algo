import java.util.*;
import java.io.*;

public class boj16918 {
    static int R, C;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static char[][] explode(char[][] cur) {
        char[][] next = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (cur[i][j] == '.') {
                    boolean safe = true;
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dr[d], nj = j + dc[d];
                        if (ni >= 0 && ni < R && nj >= 0 && nj < C && cur[ni][nj] == 'O') {
                            safe = false; break;
                        }
                    }
                    next[i][j] = safe ? 'O' : '.';
                } else {
                    next[i][j] = '.';
                }
            }
        }
        return next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] initial = new char[R][C];
        for (int i = 0; i < R; i++) initial[i] = br.readLine().toCharArray();

        char[][] result;

        if (N == 1) {
            result = initial;
        } else if (N % 2 == 0) {
            result = new char[R][C];
            for (char[] row : result) Arrays.fill(row, 'O');
        } else {
            char[][] three = explode(initial);
            char[][] five = explode(three);
            if ((N - 3) / 2 % 2 == 0) {
                result = three;
            } else {
                result = five;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char[] row : result) sb.append(new String(row)).append('\n');
        System.out.print(sb);
    }
}
import java.util.Scanner;

public class boj14504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
		int M = sc.nextInt();
        int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
        
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        int count = 0;
        
        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                count++;
            }
            
            boolean hasClean = false;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (map[nr][nc] == 0) {
                    hasClean = true;
                    break;
                }
            }
            
            if (!hasClean) {
                int backR = r - dr[d], backC = c - dc[d];
                if (map[backR][backC] == 1) break;
                r = backR;
                c = backC;
            } else {
                d = (d + 3) % 4;
                int nr = r + dr[d], nc = c + dc[d];
                if (map[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                }
            }
        }
        
        System.out.println(count);
    }
}
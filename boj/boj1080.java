import java.util.*;
import java.io.*;

public class boj1080 {
	static int N, M;
    static int[][] matrixA, matrixB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		matrixA = new int[N][M];
		matrixB = new int[N][M];

		for(int i = 0; i < N; i++) {
			String row = br.readLine();
			for(int j = 0; j < M; j++) {
				matrixA[i][j] = row.charAt(j) - '0';
			}
		}

		for(int i = 0; i < N; i++) {
			String row = br.readLine();
			for(int j = 0; j < M; j++) {
				matrixB[i][j] = row.charAt(j) - '0';
			}
		}

		int cnt = 0;
		for(int i = 0; i <= N - 3; i++) {
			for(int j = 0; j <= M - 3; j++) {
				if(matrixA[i][j] != matrixB[i][j]) {
					change(i, j);
					cnt++;
				}
			}
		}

		if(isSame()) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
	}

	static void change(int x, int y) {
		for(int i = x; i < x + 3; i++){
			for(int j = y; j < y + 3; j++){
				matrixA[i][j] = 1 - matrixA[i][j];
			}
		}
	}

	static boolean isSame() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if (matrixA[i][j] != matrixB[i][j])
					return false;
			}
		}
		return true;
	}
}
package swea4047;

import java.util.Scanner;

public class CardCounting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int[] S = new int[13];
			int[] D = new int[13];
			int[] H = new int[13];
			int[] C = new int[13];
			String str = sc.next();
			int idx = 0;
			int flag = 0;
			while(idx < str.length()) {	
				if(str.charAt(idx) == 'S') {
					int num1 = (int)(str.charAt(idx + 1) - '0');
					int num2 = (int)(str.charAt(idx + 2) - '0');
					if(S[num1 * 10 + num2 - 1] == 1) {
						flag = 1;
						break;
					}
					else
						S[num1 * 10 + num2 - 1] = 1;
				}
				else if(str.charAt(idx) == 'D') {
					int num1 = (int)(str.charAt(idx + 1) - '0');
					int num2 = (int)(str.charAt(idx + 2) - '0');
					if(D[num1 * 10 + num2 - 1] == 1) {
						flag = 1;
						break;
					}
					else
						D[num1 * 10 + num2 - 1] = 1;
				}
				else if(str.charAt(idx) == 'H') {
					int num1 = (int)(str.charAt(idx + 1) - '0');
					int num2 = (int)(str.charAt(idx + 2) - '0');
					if(H[num1 * 10 + num2 - 1] == 1) {
						flag = 1;
						break;
					}
					else
						H[num1 * 10 + num2 - 1] = 1;
				}
				else {
					int num1 = (int)(str.charAt(idx + 1) - '0');
					int num2 = (int)(str.charAt(idx + 2) - '0');
					if(C[num1 * 10 + num2 - 1] == 1) {
						flag = 1;
						break;
					}
					else
						C[num1 * 10 + num2 - 1] = 1;
				}
				idx += 3;
			}
			//계산
			int sCnt = 13;
			int dCnt = 13;
			int hCnt = 13;
			int cCnt = 13;
			for(int i = 0; i < 13; i++) {
				if(S[i] == 1)
					sCnt--;
				if(D[i] == 1)
					dCnt--;
				if(H[i] == 1)
					hCnt--;
				if(C[i] == 1)
					cCnt--;
			}
			
			if(flag == 1)
				System.out.println("#" + (t+1) + " ERROR");
			else
				System.out.println("#" + (t+1) + " " + sCnt + " " + dCnt + " " + hCnt + " " + cCnt);
		}
		sc.close();
	}
}

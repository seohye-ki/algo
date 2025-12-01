package swea1493;

import java.util.Scanner;

public class NewOperator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] result = new int[T];
		for(int t = 0; t < T; t++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			//숫자에서 좌표값 구하기 
			int n = 1;
			int x1 = 0, y1 = 0, x2 = 0, y2 = 0, ret = 0;			
			while(true) {
				if(p > 0) {
					p -= n;
					if (p <= 0) {
						x1 = n + p;
						y1 = Math.abs(p) + 1;
					}					
				}
				if(q > 0) {
					q -= n;
					if (q <= 0) {
						x2 = n + q;
						y2 = Math.abs(q) + 1;
					}					
				}
				if(p <= 0 && q <= 0)
					break;
				n++;
			}
			int x = x1 + x2;
			int y = y1 + y2;
			
			//좌표값에서 숫자구하기 
			for(int i = 0; i < x + y - 1; i++)
				ret += i;
			result[t] = ret + x;
		}
		
		//출력 
		for(int i = 0; i < T; i++)
			System.out.println("#" + (i + 1) + " " + result[i]);		
		sc.close();
	}
}

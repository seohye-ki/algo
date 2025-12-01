package swea1859;

import java.util.Scanner;

public class Millionaire {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		long[] result = new long[T];
		for(int t = 0; t < T; t++) {
			//입력 
			int N = sc.nextInt();
			int[] price = new int[N];
			for(int i = 0; i < N; i++)
				price[i] = sc.nextInt();
			
//			//계산
//			int idx = 0;
//			long total = 0;
//			while (idx < N) {
//				//비싼날 찾기 
//				int curr = idx;
//				int flag = 0;
//				while(true) {
//					if(curr + 1 < N && price[curr] <= price[curr + 1])  {
//						curr++;
//						flag = 1;
//					}
//					else
//						break;
//				}
//				if(flag == 1) {
//					for(int j = idx; j < curr; j++)
//						total += (price[curr] - price[j]);
//					idx += curr;					
//				}
//				else
//					idx++;
//			}
//			result[t] = total;
//		}
			
		//계산2 뒤에서 부터 계산하기
		int total = 0;
		int max = price[N -1];
		for(int i = N - 2; i >= 0; i--) {
			if(max > price[i])
				total += (max - price[i]);
			else {
				max = price[i];
			}
		}
		result[t] = total;
		}
			
		//출력 
		for(int i = 0; i < T; i++)
			System.out.println("#" + (i + 1) + " " + result[i]);
		sc.close();
	}
}

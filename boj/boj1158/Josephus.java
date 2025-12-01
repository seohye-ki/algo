package boj1158;

import java.util.Scanner;

public class Josephus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		
		int idx = K - 1;
		int cnt = 0;
		System.out.print("<");
		while(true) {
			//출력할 수 있는 문자인지
			System.out.print((idx + 1));
			arr[idx] = 1;
			cnt++;
			//더 돌아야 하는지 확인 
			if (cnt < N)
				System.out.print(", ");
			else
				break;
			
			//인덱스 옮기기
			int tmp = 0;
			while(tmp < K) {
				if((idx + 1) < N) {
					idx++;
					if(arr[idx] == 0)
						tmp++;
				}
				else {
					idx = 0;
					if(arr[idx] == 0)
						tmp++;
				}
			}
		}
		System.out.print(">");
		sc.close();
	}
}

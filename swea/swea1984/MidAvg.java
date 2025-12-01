package swea1984;

import java.util.Scanner;

public class MidAvg {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int[] arr = new int[10];
			for(int i = 0; i < 10; i++)
				arr[i] = sc.nextInt();
			
			//선택정렬
			for(int i = 0; i < 9; i++) {
				int min = i;
				for(int j = i + 1; j < 10; j++) {
					if(arr[j] < arr[min])
						min = j;
				}
				int tmp = arr[min];
				arr[min] = arr[i];
				arr[i] = tmp;
			}
			
			//계산
			double sum = 0;
			for(int i = 1; i < 9; i++)
				sum += arr[i];
			double avg = Math.round(sum / 8);
			System.out.println("#" + (t + 1) + " " + (int)avg);
		}
		sc.close();
	}
}

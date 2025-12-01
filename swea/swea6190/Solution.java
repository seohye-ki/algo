package swea6190;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트 케이스 수
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); //입력받을 정수 갯수
			int[] arr = new int[N]; //정수 배열
			
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			
			//모든 조합 조회
			long max = 0;
			for(int i = 0; i < N - 1; i++) {
				int num1 = arr[i];
				for(int j = i + 1; j < N; j++) {
					int num2 = arr[j];
					int number = num1 * num2;
					if(check(number)) {
						if(max < number)
							max = number;
					}
				}
			}
			
			//출력
			if(max == 0)
				System.out.println("#" + test_case + " " + -1);
			else
				System.out.println("#" + test_case + " " + max);
		}
		
		sc.close();
	}
	
	
	//단조 증가하는 수 여부 확인 메소드
	static boolean check(int number) {
		//사이즈 체크
		int size = 0;
		int n = number;
		while(n > 0) {
			n /= 10;
			size++;
		}

		//배열로 만들기
		int[] numArr = new int[size];
		n = number;
		while(n > 0) {
			numArr[--size] = n % 10;
			n /= 10;
		}
		
		//단조 증가 여부 확인
		for(int i = 0; i < numArr.length - 1; i++) {
			if(numArr[i] > numArr[i + 1])
				return false;
		}
		return true;
	}
}
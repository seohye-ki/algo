package swea1208;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[100];
		for(int t = 0;  t < 10; t++) {
			//input
			int dump = sc.nextInt();
			for(int i = 0; i < 100; i++)
				arr[i] = sc.nextInt();
			
			
			//dump
			int[] sortArr = countingSort(arr);
			for(int i = 0; i < dump; i++) {
				if(sortArr[99] - sortArr[0] <= 1)
					break;
				else {				
					//box 1개 옮기기
					sortArr[99]--;
					sortArr[0]++;
					//sort
					sortArr = countingSort(sortArr);
				}
			}
			//output
			System.out.println("#" + (t+1) + " " + (sortArr[99] - sortArr[0]));
		}
		sc.close();
	}
	
	static int[] countingSort(int[] arr) {
		int[] counting = new int[100];
		//1. 등장횟수 계산
		for(int i = 0;  i < 100; i++)
			counting[arr[i] - 1]++;
		
		//2. 누적합 계산
		for(int i = 0; i < 99; i++)
			counting[i + 1] = counting[i] + counting[i + 1];
		
		//3. 정렬하기
		int[] newArr = new int[100];
		for(int i = 99; i >= 0; i--) {				
			newArr[counting[arr[i] - 1] - 1] = arr[i];
			counting[arr[i] - 1]--;
		}
		
		return newArr;
	}
}
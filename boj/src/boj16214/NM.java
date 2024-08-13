package boj16214;

import java.util.Scanner;

public class NM {
	static long rest;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			long N = sc.nextInt();
			long M = sc.nextInt();
			rest = N % M;
			System.out.println(cal(N, M, 2)); 
		}
		sc.close();
	}
	
	static long cal(long N, long M, long i) {
		long num = N;
		for(int j = 0;  j < i;  j++) {
			num *= N;
		}
		
		long curNum = num % M;
		System.out.println("curnum : " + curNum + " num : " + num);
		
		if(curNum == rest)
			return curNum;
		else
			rest = curNum;
		
		return cal(N, M, i + 1);
	}
}

package swea1289;

import java.util.Scanner;

public class MemoryRestore {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] result = new int[T];
		for(int i = 0; i < T; i++) {
			int cnt = 0;
			String memory = sc.next();
			char[] currMemory = new char[memory.length()];
			for(int j = 0; j < memory.length(); j++)
				currMemory[j] = '0';
			
			//메모리 복구하기 
			for(int j = 0; j < memory.length(); j++) {
				if(currMemory[j] != memory.charAt(j)) {
					cnt++;
					for(int k = j; k < memory.length(); k++)
						currMemory[k] = memory.charAt(j);
				}
			}
			result[i] = cnt;
		}
		for(int i = 0; i < T; i++)
			System.out.println("#" + (i + 1) + " " + result[i]);
		sc.close();
	}
}

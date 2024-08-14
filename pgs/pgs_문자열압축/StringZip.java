package pgs_문자열압축;

import java.util.Scanner;

public class StringZip {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int answer = s.length(); //최종값
		int n = 1; //문자를 자를 단위
		while(n <= s.length() / 2) {
			int length = 0; //압축후 문자열 길이
			int i = 0;
			while (i <= s.length() - n) {
				//기준 문자열 만들기
				String origin = "";
				for(int j = 0; j < n; j++)
					origin += s.charAt(i + j);
				//중복되는 문자열이 몇개나 있는지 확인 
				System.out.println("origin : " + origin);
				int size = check(origin, s, n, i);
				System.out.println("size : " + size);
				
				//중복 문자열 없음 
				if(size == 1) {
					i += n;
					length += n;
				}
				else {
					i += (n * size);
					length += (n + 1);
				}
			}
			//나누고 남은 문자열 길이 더해주
			length += (s.length() % n);
			
			System.out.println("n : " + n + " length : " + length);
			
			if(length < answer)
				answer = length;
			n++;
		}
		
		System.out.println(answer);
		
		sc.close();
	}
	
	static int check(String origin, String str, int n, int idx) {
		int cnt = 1;
		//검사하기 
		int i = idx + n;
		while(i < str.length()) {
			if(origin.charAt(0) == str.charAt(i)) {
				int flag = 0; //0은 같음, 1은 다름 
				//끝까지 다 같은지 확인 
				for(int j = 0; j < n; j++) {
					
					System.out.println(origin.charAt(j) + " " + str.charAt(i + j));
					
					if(origin.charAt(j) != str.charAt(i + j)) {
						flag = 1;
						break;
					}
				}
				//같은 문자열임 
				if(flag == 0) {
					cnt++;
					i += n;
					System.out.println("i : " + i);
				}
				//다른 문자열임 
				else
					return cnt;
			}
			else
				return cnt;
		}
		return cnt;
	}
}

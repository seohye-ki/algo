package pgs_문자열압축;

import java.util.Scanner;

public class StringZip_v2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int answer = s.length(); //최종값
		int n = 1; //문자를 자를 단위
		while(n <= s.length() / 2) {
			StringBuilder sb = new StringBuilder();
			String preStr = ""; //이전 문자열
			int cnt = 1; //반복횟수
			for(int j = 0; j < s.length(); j += n) {
				String str = s.substring(j, Math.min(j + n, s.length()));
				if(preStr.equals(str))
					cnt++;
				else {
					if(!preStr.equals("")) {
						if(cnt == 1)
							sb.append(preStr);
						else
							sb.append(cnt).append(preStr);						
					}
					cnt = 1;
					preStr = str;
				}
			}
			if(!preStr.equals("")) {
				if(cnt == 1)
					sb.append(preStr);
				else
					sb.append(cnt).append(preStr);
			}
			
			if(sb.length() < answer)
				answer = sb.length();
			n++;
		}
		
		System.out.println(answer);
		
		sc.close();
	}
}

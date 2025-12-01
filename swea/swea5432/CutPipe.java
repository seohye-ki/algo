package swea5432;

import java.util.Scanner;

public class CutPipe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			//입력
			String pipe = sc.next();
			
			//계산
			int total = 0;
			int pipeCnt = 0;
			int i = 0;
			while(i < pipe.length()) {
				if(pipe.charAt(i) == '(') {
					if(i < pipe.length() && pipe.charAt(i + 1) == ')') {
						total += pipeCnt;
						i++;
					}
					else
						pipeCnt++;
				}
				else {
					total++;
					pipeCnt--;
				}
				i++;
			}
			
			//출력
			System.out.println("#" + (t + 1) + " " + total);
		}
		sc.close();
	}
}

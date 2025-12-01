package boj1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] cut = str.split(" ");
		int a = Integer.parseInt(cut[0]);
		int b = Integer.parseInt(cut[1]);
		int c = Integer.parseInt(cut[2]);

		System.out.println(cal(a, b, c));
	}
	
	static long cal(int a, int b, int c) {
		if(b == 0)
			return 1;
		
		long n = cal(a, b / 2, c);
		if(b % 2 == 0)
			return (n * n) % c;
		else
			return (((n * n) % c) * a) % c;
	}
}

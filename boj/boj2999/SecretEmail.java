package boj2999;

import java.util.Scanner;

public class SecretEmail {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int R = 0;
        int C = 0;
        for(int i = 1; i * i <= str.length(); i++){
            if(str.length() % i == 0){
                R = i;
                C = str.length() / i;
            }
        }
        char[][] arr = new char[R][C];
        int idx = 0;
        for(int j = 0; j < C; j++){
            for(int i = 0; i < R; i++){
                arr[i][j] = str.charAt(idx);
                idx++;
            }
        }
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++)
                System.out.print(arr[i][j]);
        }
        sc.close();
    }
}

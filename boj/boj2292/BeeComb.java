package boj2292;

import java.util.Scanner;

public class BeeComb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        //시작위치 1도 count해서 초기값이 1임.
        int move = 1;
        int i = 1;
        N--;
        while(N > 0) {
        	move++;
        	N -= (6 * i);
        	i++;
        }
        System.out.println(move);
        sc.close();
    }
}

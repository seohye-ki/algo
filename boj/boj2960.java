import java.util.Scanner;

public class boj2960 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        boolean[] isRemoved = new boolean[N + 1];
        int count = 0;

        for (int p = 2; p <= N; p++) {
            if (!isRemoved[p]) {
                for (int j = p; j <= N; j += p) {
                    if (!isRemoved[j]) {
                        isRemoved[j] = true;
                        count++;
                        
                        if (count == K) {
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
    }
}
package swea5658;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static String hex = "0123456789ABCDEF";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int K = sc.nextInt();
			String str = sc.next();

			Queue<Character> queue = new LinkedList<>();
			List<Integer> result = new ArrayList<>();
			for(int i = 0; i < N; i++)
				queue.add(str.charAt(i));
			for(int k = 0; k < N / 4; k++) {
				for(int n = 0; n < 4; n++) {
					int sum = 0;
					for(int i = 0; i < N / 4; i++) {
						char tmp = queue.poll();
//						System.out.println(tmp);
//						System.out.println(((int) Math.pow(16, N / 4 - 1 - i) * hex.indexOf(tmp)));
						sum += ((int) Math.pow(16, N / 4 - 1 - i) * hex.indexOf(tmp));
						queue.add(tmp);
					}
					int flag = 0;
					for(int j = 0; j < result.size(); j++) {
						if(result.get(j) == sum) {
							flag = 1;
							break;
						}
					}
					if(flag == 0)
						result.add(sum);
				}
				queue.add(queue.poll());
			}
			int[] list = new int[result.size()];
			for(int i = 0; i < result.size(); i++)
				list[i] = result.get(i);
			Arrays.sort(list);
//			System.out.println(Arrays.toString(list));
			System.out.println("#" + test_case + " " + list[result.size() - K]);
		}
	
		
		sc.close();
	}
}

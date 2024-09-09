package boj2504;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next(); //괄호 문자열
		Stack<Character> stack = new Stack<>(); //괄호 넣을 스택
		Stack<Integer> answer = new Stack<>(); //값 임시저장
		
		int result = 0;
		int value = 1;
		int flag = 1;
		for(int i = 0; i < str.length(); i++) {
			char letter = str.charAt(i);
			
			//여는 괄호라면 stack에 넣기
			if(letter == '(' || letter == '[') {
				stack.push(letter);
				if(letter == '(')
					value *= 2;
				else
					value *= 3;
				flag = 1;
			}
			
			//닫는 괄호라면 stack에서 하나 꺼내기
			else {
				//꺼낼 것이 없다면 invalid
				if(stack.isEmpty()) {
					System.out.println(0);
					return;
				}
				//꺼낼 것이 있다면
				char top = stack.pop();
				if(letter == ')') {
					//invalid(괄호짝 안맞음)
					if(top != '(') {
						System.out.println(0);
						return;
					}
					else {
						if(flag == 1) {
							result += (value / 2); 
						}
						else {
							result *= value;
						}
						value /= 2;
						flag = 0;
					}
				}
				else if(letter == ']'){
					//invalid(괄호짝 안맞음)
					if(top != '[') {
						System.out.println(0);
						return;
					}
					else {
						if(flag == 1) {
							result += (value / 3); 
						}
						else {
							result *= value;
						}
						value /= 3;
						flag = 0;
					}
				}
			}
		}
		
		//짝 안맞을때
		if(!stack.isEmpty())
			System.out.println(0);
		else
			System.out.println(result);
	}
}

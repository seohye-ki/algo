str = input()

answer = ""
stack = []
for c in str:
	if c.isalpha():
		answer += c
	elif c == '(':
		stack.append(c)
	elif c == ')':
		while stack and stack[-1] != '(':
			answer += stack.pop()
		stack.pop()
	elif c == "+" or c == '-':
		while stack and stack[-1] in ['+', '-', '*', '/']: 
			answer += stack.pop()
		stack.append(c)
	elif c == "*" or c == '/':
		while stack and stack[-1] in ['*', '/']:
			answer += stack.pop()
		stack.append(c)
			
while stack:
	answer += stack.pop()

print(answer)
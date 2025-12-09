press = input()
stack = []
for c in press:
	stack.append(c)

tmp = []
while stack:
	c = stack.pop()
	if c == '(':
		length = 0
		while tmp[-1] != ')':
			item = tmp.pop()
			if isinstance(item, int):
				length += item
			else:
				length += 1
		tmp.pop() #닫는 괄호 없애기
		n = int(stack.pop())
		tmp.append(length * n)
	else:
		tmp.append(c)
total = 0
for s in tmp:
	if isinstance(s, int):
		total += s
	else:
		total += 1
print(total)
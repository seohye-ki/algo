str = input()
bomb = input()
bomb_len = len(bomb)

stack = []
for c in str:
	stack.append(c)

	if bomb_len <= len(stack):
		if ''.join(stack[-bomb_len:]) == bomb:
			for _ in range(bomb_len):
				stack.pop()

if stack:
	print(''.join(stack))
else:
	print('FRULA')

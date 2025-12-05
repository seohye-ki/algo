import sys
input = sys.stdin.readline
from collections import deque

N = int(input())
tops = list(map(int, input().split()))
answer = [0] * N
stack = []

for i in range(N):
	while stack:
		if stack[-1][1] < tops[i]:
			stack.pop()
		else:
			break
	if stack:
		answer[i] = stack[-1][0] + 1
	stack.append((i, tops[i]))

print(*answer)
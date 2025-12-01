import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
	N = int(input())
	dict = {}
	for _ in range(N):
		C,H = input().split()
		dict[C] = H

	answer = 1
	types = set(dict.values())
	for t in types:
		cnt = list(dict.values()).count(t)
		answer *= (cnt + 1)
	answer -= 1
	print(answer)
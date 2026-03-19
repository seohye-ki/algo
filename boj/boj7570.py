import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

pos = [0] * (n + 1)
for i, v in enumerate(arr):
	pos[v] = i

max_len = 1
cur_len = 1
for i in range(2, n + 1):
	if pos[i] > pos[i - 1]:
		cur_len += 1
		max_len = max(max_len, cur_len)
	else:
		cur_len = 1

print(n - max_len)
import sys
input = sys.stdin.readline
N = int(input())
line = []
for _ in range(N):
	a, b = map(int, input().split())
	line.append((a, b))

line.sort()
dp = [1] * N
for i in range(1, N):
	for j in range(i):
		if line[j][1] < line[i][1]:
			dp[i] = max(dp[i], dp[j] + 1)

maximum = max(dp)
print(N - maximum)
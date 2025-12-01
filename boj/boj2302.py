import sys
input = sys.stdin.readline

N = int(input())
M = int(input())

dp = [0] * (N + 1)
dp[0] = 1
if N >= 1:
	dp[1] = 1
for i in range(2, N + 1):
	dp[i] = dp[i - 1] + dp[i - 2]

arr = [1]
start = 0
for _ in range(M):
	fix = int(input())
	if fix - start > 1:
		arr.append(dp[fix - start - 1])
	start = fix
arr.append(dp[N - start])

answer = 1
for x in arr:
	answer *= x
print(answer)
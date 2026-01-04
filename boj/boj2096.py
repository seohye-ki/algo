import sys
input = sys.stdin.readline

N = int(input())

max_dp = [0] * 3
min_dp = [0] * 3
for _ in range(N):
	line = list(map(int, input().split()))
	max_dp0 = max(max_dp[0], max_dp[1]) + line[0]
	max_dp1 = max(max_dp[0], max_dp[1], max_dp[2]) + line[1]
	max_dp2 = max(max_dp[1], max_dp[2]) + line[2]

	min_dp0 = min(min_dp[0], min_dp[1]) + line[0]
	min_dp1 = min(min_dp[0], min_dp[1], min_dp[2]) + line[1]
	min_dp2 = min(min_dp[1], min_dp[2]) + line[2]

	max_dp = [max_dp0, max_dp1, max_dp2]
	min_dp = [min_dp0, min_dp1, min_dp2]

max_score = max(max_dp)
min_score = min(min_dp)
print(max_score, min_score)
import sys
input = sys.stdin.readline

N = int(input())
costs = [(0, 0, 0)]
for i in range(N):
	cost = list(map(int, input().split()))
	costs.append(cost)

INF = float('inf')
answer = INF
for k in range(3):
	dp = [[0] * 3 for _ in range(N + 1)]
	dp[1][0] = INF
	dp[1][1] = INF
	dp[1][2] = INF
	dp[1][k] = costs[1][k]
	for i in range(2, N + 1):
		dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0]
		dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1]
		dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2]
	
	for i in range(3):
		if i != k:
			answer = min(answer, dp[N][i])

print(answer)
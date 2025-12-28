N, K = map(int, input().split())
dp = [[0] * (N+1) for _ in range(K+1)]
dp[0][0] = 1
# i개를 사용해서 N만들기
for k in range(1, K+1):
	for n in range(N+1):
		if n == 0:
			dp[k][n] = 1
		else:
			dp[k][n] = (dp[k-1][n] + dp[k][n-1]) % 1000000000
print(dp[K][N])
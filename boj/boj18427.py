import sys
input = sys.stdin.readline

N, M, H = map(int, input().split())
blocks = []
for _ in range(N):
	one = list(map(int, input().split()))
	blocks.append(one)

dp = [[0] * (H + 1) for _ in range(N + 1)]
dp[0][0] = 1
for i in range(1, N + 1):
	for h in range(H + 1):
		dp[i][h] = dp[i-1][h]
		for block_h in blocks[i-1]:
			if h - block_h >= 0:
				dp[i][h] += dp[i-1][h-block_h]
				dp[i][h] %= 10007
print(dp[N][H])

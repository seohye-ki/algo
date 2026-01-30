N, K = map(int, input().split())
coins = []
for _ in range(N):
    coins.append(int(input()))

dp = [float('inf')] * (K + 1)
dp[0] = 0

for i in range(1, K + 1):
    for coin in coins:
        if i >= coin:
            dp[i] = min(dp[i], dp[i - coin] + 1)

if dp[K] == float('inf'):
    print(-1)
else:
    print(dp[K])
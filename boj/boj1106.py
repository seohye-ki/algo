import sys
input = sys.stdin.readline

C, N = map(int, input().split())
costs = []
guests = []
for _ in range(N):
	cost, guest = map(int, input().split())
	costs.append(cost)
	guests.append(guest)

INF = float('inf')
dp = [INF] * (C + max(guests))
dp[0] = 0

for i in range(N):
	c = costs[i]
	g = guests[i]

	for j in range(g, C + max(guests)):
		if dp[j - g] != INF:
			dp[j] = min(dp[j], dp[j - g] + c)

answer = min(dp[C:])
print(answer)
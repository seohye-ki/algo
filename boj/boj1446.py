import sys
input = sys.stdin.readline

N, D = map(int, input().split())
shortcuts = []
for _ in range(N):
    s, e, l = map(int, input().split())
    if e <= D:
        shortcuts.append((s, e, l))

INF = float('inf')
dp = [INF] * (D + 1)
dp[0] = 0

for i in range(1, D + 1):
    dp[i] = min(dp[i], dp[i-1] + 1)
    for s, e, l in shortcuts:
        if e == i:
            dp[i] = min(dp[i], dp[s] + l)

print(dp[D])
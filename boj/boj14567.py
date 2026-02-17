import sys
input = sys.stdin.readline

N, M = map(int, input().split())

lectures = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    lectures[b].append(a)

dp = [1] * (N + 1)

for i in range(1, N + 1):
    for a in lectures[i]:
        dp[i] = max(dp[i], dp[a] + 1)

print(*dp[1:])
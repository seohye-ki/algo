import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

N = int(input())
bamboos = []
for _ in range(N):
	arr = list(map(int, input().split()))
	bamboos.append(arr)

dp = [[0] * N for _ in range(N)]
dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def dfs(x, y):
	if dp[x][y] != 0:
		return dp[x][y]

	dp[x][y] = 1

	for dx, dy in dir:
		nx = x + dx
		ny = y + dy
		if 0 <= nx < N and 0 <= ny < N:
			if bamboos[x][y] < bamboos[nx][ny]:
				dp[x][y] = max(dp[x][y], dfs(nx, ny) + 1)
	
	return dp[x][y]

answer = 0
for i in range(N):
	for j in range(N):
		answer = max(answer, dfs(i, j))
print(answer)
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N = int(input())
arr = []
max_hight = 0
for i in range(N):
	line = list(map(int, input().split()))
	max_hight = max(max_hight, max(line))
	arr.append(line)

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]
def dfs(x, y, h, visited):
	visited[x][y] = True

	for k in range(4):
		nx = x + dir[k][0]
		ny = y + dir[k][1]
		if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and arr[nx][ny] > h:
			dfs(nx, ny, h, visited)

# 0 ~ N까지 잠길때 찾기
max_cnt = 0
for h in range(max_hight + 1):
	cnt = 0
	visited = [[False] * N for _ in range(N)]
	for i in range(N):
		for j in range(N):
			if not visited[i][j] and arr[i][j] > h:
				dfs(i, j, h, visited)
				cnt += 1
	max_cnt = max(cnt, max_cnt)

print(max_cnt)
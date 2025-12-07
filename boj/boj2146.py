import sys
input = sys.stdin.readline
from collections import deque

N = int(input())
maps = []
for _ in range(N):
	line = list(map(int, input().split()))
	maps.append(line)

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]
visited = [[False]*N for _ in range(N)]
def find_land(r, c, g):
	q = deque([(r, c)])
	visited[r][c] = True
	maps[r][c] = g

	while q:
		a, b = q.popleft()
		for k in range(4):
			na, nb = a + dir[k][0], b + dir[k][1]
			if 0 <= na < N and 0 <= nb < N and not visited[na][nb] and maps[na][nb] == 1:
				visited[na][nb] = True
				maps[na][nb] = g
				q.append((na, nb))

land = 2
for i in range(N):
	for j in range(N):
		if not visited[i][j] and maps[i][j] == 1:
			find_land(i, j, land)
			land += 1

answer = float('inf')
for g in range(2, land):
	q = deque()

	for i in range(N):
		for j in range(N):
			if maps[i][j] == g:
				for k in range(4):
					ni, nj = i + dir[k][0], j + dir[k][1]
					if 0 <= ni < N and 0 <= nj < N and maps[ni][nj] == 0:
						q.append((i, j, 0))
						dist[i][j] = 0
						break
	
	flag = False
	dist = [[-1]*N for _ in range(N)]
	while q and not flag:
		a, b, d = q.popleft()
		for k in range(4):
			na, nb = a + dir[k][0], b + dir[k][1]
			if 0 <= na < N and 0 <= nb < N:
				if maps[na][nb] == 0 and dist[na][nb] == -1:
					dist[na][nb] = d + 1
					q.append((na, nb, d + 1))
				elif maps[na][nb] != 0 and maps[na][nb] != g:
					answer = min(answer, d)
					flag = True
					break
print(answer)
import sys
input = sys.stdin.readline
from collections import deque

N, M = map(int, input().split())
maps = []
for i in range(N):
	line = list(map(int, input().split()))
	maps.append(line)

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def find_air():
	visited = [[False]*M for _ in range(N)]
	outside_air = [[False]*M for _ in range(N)]
	q = []

	for i in range(N):
		for j in range(M):
			if (i == 0 or i == N - 1 or j == 0 or j == M - 1) and not visited[i][j] and maps[i][j] == 0:
				visited[i][j] = True
				q.append((i, j))

	while q:
		r, c = q.pop()
		outside_air[r][c] = True

		for k in range(4):
			nr, nc = r + dir[k][0], c + dir[k][1]
			if 0 <= nr < N and 0 <= nc < M and not visited[nr][nc] and maps[nr][nc] == 0:
				visited[nr][nc] = True
				q.append((nr, nc))

	return outside_air

time = 0
while True:
	melted = []
	outside_air = find_air()
	for i in range(N):
		for j in range(M):
			if maps[i][j] == 1:
				m = 0
				for k in range(4):
					nr, nc = i + dir[k][0], j + dir[k][1]
					if 0 <= nr < N and 0 <= nc < M:
						if outside_air[nr][nc]:
							m += 1
				if 2 <= m:
					melted.append((i, j))
	if not melted:
		break

	for r, c in melted:
		maps[r][c] = 0

	time += 1

print(time)


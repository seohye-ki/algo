from collections import deque
import sys
input = sys.stdin.readline

N, M, R, C = map(int, input().split())

rooms = []
for _ in range(R):
	a, b, p = map(int, input().split())
	rooms.append((a-1, b-1, p))

dist = [[-1] * M for _ in range(N)]
dq = deque()

for _ in range(C):
	c, d = map(int, input().split())
	dist[c-1][d-1] = 0
	dq.append((c-1, d-1))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

while dq:
	x, y = dq.popleft()
	for i in range(4):
		nx, ny = x + dx[i], y + dy[i]
		if 0 <= nx < N and 0 <= ny < M and dist[nx][ny] == -1:
			dist[nx][ny] = dist[x][y] + 1
			dq.append((nx, ny))

ans = float('inf')
for a, b, p in rooms:
	ans = min(ans, dist[a][b] * p)

print(ans)
from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(N)]

dist = [[-1] * M for _ in range(N)]
q = deque()

for r in range(N):
    for c in range(M):
        if grid[r][c] == 1:
            dist[r][c] = 0
            q.append((r, c))

dirs = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
while q:
    r, c = q.popleft()
    for dr, dc in dirs:
        nr, nc = r + dr, c + dc
        if 0 <= nr < N and 0 <= nc < M and dist[nr][nc] == -1:
            dist[nr][nc] = dist[r][c] + 1
            q.append((nr, nc))

max_dist = 0
for r in range(N):
    for c in range(M):
        max_dist = max(max_dist, dist[r][c])
print(max_dist)
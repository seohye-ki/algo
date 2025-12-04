import sys
input = sys.stdin.readline
from collections import deque

N, M = map(int, input().split())
maps = [[0]*M for _ in range(N)]
for i in range(N):
	line = list(map(int, input().strip()))
	maps[i] = line

visited = [[False]*M for _ in range(N)]
dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]
groups = {}
def bfs(r, c, group):
    queue = deque([(r, c)])
    visited[r][c] = True
    maps[r][c] = group
    count = 1
    
    while queue:
        r, c = queue.popleft()
        for k in range(4):
            nr, nc = r + dir[k][0], c + dir[k][1]
            if 0 <= nr < N and 0 <= nc < M and not visited[nr][nc] and maps[nr][nc] == 0:
                visited[nr][nc] = True
                maps[nr][nc] = group
                queue.append((nr, nc))
                count += 1

    return count

g = 2
for i in range(N):
	for j in range(M):
		if maps[i][j] == 0 and not visited[i][j]:
			cnt = bfs(i, j, g)
			groups[g] = cnt
			g += 1

answer = [[0] * M for _ in range(N)]
for i in range(N):
	for j in range(M):
		if maps[i][j] == 1:
			available = set()
			for k in range(4):
				nr, nc = i + dir[k][0], j + dir[k][1]
				if 0 <= nr < N and 0 <= nc < M and maps[nr][nc] >= 2:
					available.add(maps[nr][nc])
			total = 1
			for num in available:
				total += groups[num]
			answer[i][j] = total % 10

for i in range(N):
	print(''.join(map(str, answer[i])))
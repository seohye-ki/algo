import sys
input = sys.stdin.readline
from collections import deque

INF = float('inf')
R, C = map(int, input().split())
fire = [[INF] * C for _ in range(R)]
maps = [['.'] * C for _ in range(R)]
pos = []

fq = deque()
for i in range(R):
	line = input().strip()
	for j, c in enumerate(line):
		maps[i][j] = c
		if c == 'J':
			pos = [i, j]
		elif c == 'F':
			fq.append((i, j, 0))
			fire[i][j] = 0

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]
while fq:
	r, c, turn = fq.popleft()
	
	for dr, dc in dir:
		nr, nc = r + dr, c + dc
		if 0 <= nr < R and 0 <= nc < C and fire[nr][nc] == INF and maps[nr][nc] != '#':
			fq.append((nr, nc, turn + 1))
			fire[nr][nc] = turn + 1

dist = [[INF] * C for _ in range(R)]
dist[pos[0]][pos[1]] = 0
q = deque([(pos[0], pos[1], 0)])

answer = INF
while q:
	r, c, turn = q.popleft()

	for dr, dc in dir:
		nr, nc = r + dr, c + dc
		if not (0 <= nr < R and 0 <= nc < C):
			answer = min(answer, turn + 1)
			continue
		if maps[nr][nc] != '#' and dist[nr][nc] == INF and turn + 1 < fire[nr][nc]:
			q.append((nr, nc, turn + 1))
			dist[nr][nc] = turn + 1

if answer == INF:
	print("IMPOSSIBLE")
else:
	print(answer)

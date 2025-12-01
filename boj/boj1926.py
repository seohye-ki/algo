import sys
input = sys.stdin.readline
from collections import deque

N, M = map(int, input().split())
board = [[] for _ in range(N)]

for i in range(N):
	tmp = list(map(int, input().split()))
	for j in range(M):
		board[i].append(tmp[j])

def bfs(r, c):
	dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]
	scale = 1
	board[r][c] = 2
	dq = deque([(r, c)])

	while dq:
		r, c = dq.popleft()
		for i in range(4):
			nr, nc = r + dir[i][0], c + dir[i][1]
			if 0 <= nr < N and 0 <= nc < M and board[nr][nc] == 1:
				scale += 1
				board[nr][nc] = 2
				dq.append((nr, nc))
	return scale

count = 0
biggest = 0
for i in range(N):
	for j in range(M):
		if board[i][j] == 1:
			tmp = bfs(i, j)
			count += 1
			biggest = max(biggest, tmp)

print(count)
print(biggest)
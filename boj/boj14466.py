import sys
input = sys.stdin.readline
from collections import deque

N, K, R = map(int, input().split())

roads = []
for _ in range(R):
	r1, c1, r2, c2 = map(int, input().split())
	roads.append((r1 - 1, c1 - 1, r2 - 1, c2 - 1))
	roads.append((r2 - 1, c2 - 1, r1 - 1, c1 - 1))

cows = [] 
for _ in range(K):
	r, c = map(int, input().split())
	cows.append((r - 1, c - 1))

board = [[0] * N for _ in range(N)]
group = 1
def bfs(r, c):
	board[r][c] = group
	dr = [1, -1, 0 ,0]
	dc = [0, 0, -1, 1]

	que = deque([(r, c)])
	while que:
		r, c = que.popleft()
		for i in range(4):
			nr = r + dr[i]
			nc = c + dc[i]
			if 0 <= nr < N and 0 <= nc < N and board[nr][nc] == 0:
				if (r, c, nr, nc) not in roads:
					board[nr][nc] = group
					que.append((nr, nc))

for i in range(N):
	for j in range(N):
		if board[i][j] == 0:
			bfs(i, j)
			group += 1

cow_num = []
for r, c in cows:
	cow_num.append(board[r][c])

answer = 0
for i in range(K):
	for j in range(i + 1, K):
		if cow_num[i] != cow_num[j]:
			answer += 1

print(answer)
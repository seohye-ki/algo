from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = []
for i in range(N):
	board.append(list(map(int, input().split())))

# 빙산 조각수 계산
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

def bfs(i, j, visited):
	q = deque([(i, j)])
	visited[i][j] = 1
	while q:
		r, c = q.popleft()
		for k in range(4):
			nr = r + dr[k]
			nc = c + dc[k]
			if 0 <= nr < N and 0 <= nc < M and visited[nr][nc] != 1 and 0 < board[nr][nc]:
				visited[nr][nc] = 1
				q.append((nr, nc))

ice = [(i, j) for i in range(N) for j in range(M) if board[i][j] > 0]
year = 0

while True:
	year += 1
	melt = []
	changed = False
	# 빙산 줄이기
	for r, c in ice:
		if 0 < board[r][c]:
			tmp = board[r][c]
			for k in range(4):
				nr = r + dr[k]
				nc = c + dc[k]
				if 0 <= nr < N and 0 <= nc < M and board[nr][nc] == 0:
					tmp = max(0, tmp - 1)
			if tmp != board[r][c]:
				changed = True
			melt.append((r, c, tmp))
	if not changed:
		print(0)
		break

	newice = []
	for r, c, value in melt:
		board[r][c] = value
		if 0 < value:
			newice.append((r, c))
	ice = newice

	if not ice:
		print(0)
		break

	# 조각 세기
	visited = [[0] * M for _ in range(N)]
	piece = 0
	for r, c in ice:
		if visited[r][c] == 0:
			bfs(r, c, visited)
			piece += 1

	if 1 < piece:
		print(year)
		break
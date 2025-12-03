import sys
input = sys.stdin.readline
from collections import deque

M, N, H = map(int, input().split())
tomatos = [[[-1] * M for _ in range(N)] for _ in range(H)]
dq = deque()
unripe = 0

for k in range(H):
	for i in range(N):
		line = list(map(int, input().split()))
		for j in range(M):
			tomatos[k][i][j] = line[j]
			if line[j] == 1:
				dq.append((k, i, j, 0))
			elif line[j] == 0:
				unripe += 1

if unripe == 0:
	print(0)
	exit()

dir = [(0, -1, 0), (0, 1, 0), (0, 0, -1), (0, 0, 1), (-1, 0, 0), (1, 0, 0)] # 상하좌우 위아래
days = 0
ripe = 0

while dq:
	l, r, c, day = dq.popleft()
	days = day

	for i in range(6):
		nl = l + dir[i][0]
		nr = r + dir[i][1]
		nc = c + dir[i][2]
		if 0 <= nl < H and 0 <= nr < N and 0 <= nc < M and tomatos[nl][nr][nc] == 0:
			tomatos[nl][nr][nc] = 1
			ripe += 1
			dq.append((nl, nr, nc, day+1))

if ripe == unripe:
	print(days)
else:
	print(-1)
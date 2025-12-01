import sys
from collections import deque
input = sys.stdin.readline

dc = [1, -1, 0, 0, 0, 0]
dr = [0, 0, 1, -1, 0, 0]
dl = [0, 0, 0, 0, 1, -1]

while True:
	L, R, C = map(int, input().split())
	if L == 0 and R == 0 and C == 0:
		break

	# 빈공간 0, 벽 1, 시작 2, 출구 3
	building = [[[0] * C for _ in range(R)] for _ in range(L)]
	start_c, start_r, start_l = 0, 0, 0
	exit_c, exit_r, exit_l = 0, 0, 0

	for i in range(L):
		for j in range(R):
			line = input()
			for k in range(C):
				if line[k] == '#':
					building[i][j][k] = 1
				elif line[k] == 'S':
					building[i][j][k] = 2
					start_c, start_r, start_l = k, j, i
				elif line[k] == 'E':
					building[i][j][k] = 3
					exit_c, exit_r, exit_l = k, j, i
		input()
	
	dist = [[[-1] * C for _ in range(R)] for _ in range(L)]
	dist[start_l][start_r][start_c] = 0
	q = deque([(start_c, start_r, start_l)])
	while q:
		c, r, l = q.popleft()
		for k in range(6):
			nc = c + dc[k]
			nr = r + dr[k]
			nl = l + dl[k]
			if 0 <= nc < C and 0 <= nr < R and 0 <= nl < L and building[nl][nr][nc] != 1 and dist[nl][nr][nc] == -1:
				dist[nl][nr][nc] = dist[l][r][c] + 1
				q.append((nc, nr, nl))

	if dist[exit_l][exit_r][exit_c] == -1:
		print('Trapped!')
	else:
		print(f'Escaped in {dist[exit_l][exit_r][exit_c]} minute(s).')
N = int(input())
curb = []
board = [[False]*101 for _ in range(101)]

dy = [0, -1, 0, 1]
dx = [1, 0, -1, 0]

for _ in range(N):
	x, y, d, g = map(int, input().split())
	dir = [d]
	for gen in range(g):
		for i in range(len(dir) - 1, -1, -1):
			dir.append((dir[i] + 1) % 4)
		
	board[y][x] = True
	for i in dir:
		x += dx[i]
		y += dy[i]
		board[y][x] = True

answer = 0
for i in range(100):
	for j in range(100):
		if board[i][j] and board[i+1][j] and board[i][j+1] and board[i+1][j+1]:
			answer += 1
print(answer)
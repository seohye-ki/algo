import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

dc = [0, 0, -1, 1]
dr = [-1, 1, 0, 0]

N, M = map(int, input().split())
board = [[0] * M for _ in range(N)]
for i in range(N):
	line = list(map(int, input().split()))
	for j in range(M):
		board[i][j] = line[j]

visited = [[0] * M for _ in range(N)]
maximum = 0
max_value = max(map(max, board))

def dfs(x, y, cnt, sum):
	global maximum
	if sum + (4 - cnt) * max_value <= maximum:
		return
	if 4 == cnt:
		maximum = max(sum, maximum)
		return
	
	for i in range(4):
		nx = x + dr[i]
		ny = y + dc[i]
		if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] != 1:
			visited[nx][ny] = 1
			dfs(nx, ny, cnt + 1, sum + board[nx][ny])
			visited[nx][ny] = 0

def check_t(x, y):
    global maximum
    # ㅜ
    if x - 1 >= 0 and y - 1 >= 0 and y + 1 < M:
        s = board[x][y] + board[x - 1][y - 1] + board[x - 1][y] + board[x - 1][y + 1]
        maximum = max(maximum, s)
    # ㅗ
    if x + 1 < N and y - 1 >= 0 and y + 1 < M:
        s = board[x][y] + board[x + 1][y - 1] + board[x + 1][y] + board[x + 1][y + 1]
        maximum = max(maximum, s)
    # ㅏ
    if y - 1 >= 0 and x - 1 >= 0 and x + 1 < N:
        s = board[x][y] + board[x - 1][y - 1] + board[x][y - 1] + board[x + 1][y - 1]
        maximum = max(maximum, s)
    # ㅓ
    if y + 1 < M and x - 1 >= 0 and x + 1 < N:
        s = board[x][y] + board[x - 1][y + 1] + board[x][y + 1] + board[x + 1][y + 1]
        maximum = max(maximum, s)

for i in range(N):
	for j in range(M):
		visited[i][j] = 1
		dfs(i, j, 1, board[i][j])
		visited[i][j] = 0
		check_t(i, j)

print(maximum)
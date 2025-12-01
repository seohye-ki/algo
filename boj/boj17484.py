N, M = map(int, input().split())
board = []
for _ in range(N):
	board.append(list(map(int, input().split())))

dp = [[[0] * 3 for _ in range(M)] for _ in range(N)]

for i in range(M):
	dp[0][i][0] = board[0][i]
	dp[0][i][1] = board[0][i]
	dp[0][i][2] = board[0][i]

INF = 1000000000
for i in range(1, N):
	for j in range(M):
		# 왼쪽
		if j == 0:
			dp[i][j][0] = INF
		else:
			dp[i][j][0] = board[i][j] + min(dp[i-1][j-1][1], dp[i-1][j-1][2])
		# 가운데
		dp[i][j][1] = board[i][j] + min(dp[i-1][j][0], dp[i-1][j][2])
		# 오른쪽
		if j == M-1:
			dp[i][j][2] = INF
		else:
			dp[i][j][2] = board[i][j] + min(dp[i-1][j+1][0], dp[i-1][j+1][1])
			
answer = INF
for j in range(M):
	for k in range(3):
		answer = min(answer, dp[N-1][j][k])
print(answer)
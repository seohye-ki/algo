import sys
input = sys.stdin.readline

T, W = map(int, input().split())
fall = [0]
for _ in range(T):
	tree = int(input())
	fall.append(tree)

dp = [[0] * (W + 1) for _ in range(T + 1)]
for i in range(1, T + 1):
	for j in range(W + 1):
		if i < j:
			continue
		
		stand = 1 # 초기값
		if j % 2 == 1: #2번 나무에 서있음
			stand = 2
		
		if j == 0:
			if stand == fall[i]:
				dp[i][j] = dp[i - 1][j] + 1
			else:
				dp[i][j] = dp[i - 1][j]
		else:
			if stand == fall[i]:
				dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + 1 # dp[i - 1][j - 1] 움직여서 온 경우 dp[i - 1][j] 안 움직이고 온 경우
			else:
				dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j])
answer = max(dp[T])
print(answer)
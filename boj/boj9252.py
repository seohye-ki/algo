import sys
input = sys.stdin.readline

str1 = input().strip()
str2 = input().strip()
N, M = len(str1), len(str2)
dp = [[0] * (M + 1) for _ in range(N + 1)]
for i in range(1, N+1):
	for j in range(1, M+1):
		if str1[i-1] == str2[j-1]:
			dp[i][j] = dp[i - 1][j - 1] + 1
		else:
			dp[i][j] = max(dp[i-1][j], dp[i][j-1])

print(dp[N][M])
answer = ['0'] * dp[N][M]
i = N
j = M
idx = dp[N][M] - 1
while dp[i][j] != 0:
	if str1[i-1] == str2[j-1]:
		answer[idx] = str1[i-1]
		idx -= 1
		i -= 1
		j -= 1
	else:	
		if dp[i - 1][j] < dp[i][j - 1]:
			j = j - 1
		else:
			i = i - 1
print(''.join(map(str, answer)))
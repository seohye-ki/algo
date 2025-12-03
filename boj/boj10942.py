import sys
input = sys.stdin.readline

N = int(input())
num_arr = list(map(int, input().split()))
M = int(input())

dp = [[False]*N for _ in range(N)]

# 1개짜리
for i in range(N):
	dp[i][i] = True

# 2개짜리
for i in range(N-1):
	if num_arr[i] == num_arr[i+1]:
		dp[i][i+1] = True
		dp[i+1][i] = True

# 3개 이상
for i in range(3, N+1):
	for j in range(N - i + 1):
		if num_arr[j] == num_arr[j + i - 1] and dp[j + 1][j + i - 2]:
			dp[j][j+i-1] = True

for _ in range(M):
	S, E = map(int, input().split())
	if dp[S-1][E-1]:
		print(1)
	else:
		print(0)
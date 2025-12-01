# import sys
# input = sys.stdin.readline

# N = int(input())
# schedules = [(0,0)]
# for _ in range(N):
# 	T, P = map(int, input().split())
# 	schedules.append((T, P))

# dp = [0] * (N + 2)
# for i in range(1, N + 1):
# 	# i일에 상담하지 않을때
# 	dp[i] = max(dp[i], dp[i - 1])
# 	# i일에 상담 할때
# 	if i + schedules[i][0] <= N + 1:
# 		dp[i + schedules[i][0]] = max(dp[i + schedules[i][0]], dp[i] + schedules[i][1])

# answer = max(dp[:N + 2])
# print(answer)

import sys
input = sys.stdin.readline

N = int(input())
time = []
price = []
for _ in range(N):
	T, P = map(int, input().split())
	time.append(T)
	price.append(P)

dp = [0] * (N + 1) # 0일이랑 N + 1일 추가
for i in range(N-1, -1, -1):
	if i + time[i] <= N:
		dp[i] = max(dp[i + 1], price[i] + dp[i + time[i]])
	else:
		dp[i] = dp[i + 1]

print(dp[0])
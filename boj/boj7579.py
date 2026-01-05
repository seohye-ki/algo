# N, M = map(int, input().split())
# memories = list(map(int, input().split()))
# costs = list(map(int, input().split()))
# max_cost = sum(costs)

# dp = [0] * (max_cost + 1)
# for i in range(N):
# 	for j in range(max_cost, costs[i] - 1, -1):
# 		dp[j] = max(dp[j], dp[j - costs[i]] + memories[i])
	
# for i in range(max_cost + 1):
# 	if M <= dp[i]:
# 		print(i)
# 		break

N, M = map(int, input().split())
memories = list(map(int, input().split()))
costs = list(map(int, input().split()))
max_cost = sum(costs)

dp = [[0] * (max_cost + 1) for _ in range(N + 1)]
for i in range(1, N + 1):
	for j in range(max_cost + 1):
		dp[i][j] = dp[i - 1][j]
		if j - costs[i - 1] >= 0:
			dp[i][j] = max(dp[i][j], dp[i - 1][j - costs[i - 1]] + memories[i - 1])

	# print("\n앱\\비용 ", end="")
	# for j in range(min(max_cost + 1, 20)):  # 비용 0~19만 출력
	# 	print(f"{j:4d}", end="")
	# print()
	# print("-" * 80)
    
    # # 각 행 출력
	# for row in range(i + 1):
	# 	if row == 0:
	# 		print(f"  앱X  ", end="")
	# 	else:
	# 		print(f"  앱{row}  ", end="")
        
	# 	for j in range(min(max_cost + 1, 20)):
	# 		print(f"{dp[row][j]:4d}", end="")
	# 	print()

for i in range(max_cost + 1):
    if M <= dp[N][i]:
        print(i)
        break
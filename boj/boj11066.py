import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
	K = int(input())
	arr = list(map(int, input().split()))
	
	prefix = [0] * (K+1)
	for i in range(K):
		prefix[i+1] = prefix[i] + arr[i]

	dp = [[0] * K for _ in range(K)]
	for length in range(2, K+1):
		for start_idx in range(K-length+1):
			end_idx = start_idx + length - 1
			cost = prefix[end_idx+1] - prefix[start_idx]

			dp[start_idx][end_idx] = dp[start_idx][start_idx] + dp[start_idx+1][end_idx] + cost
			for div_idx in range(start_idx+1, end_idx):
				tmp = dp[start_idx][div_idx] + dp[div_idx+1][end_idx] + cost
				if tmp < dp[start_idx][end_idx]:
					dp[start_idx][end_idx] = tmp
	print(dp[0][K-1])
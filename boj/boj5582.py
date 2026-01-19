str1 = input()
str2 = input()
str1_len = len(str1)
str2_len = len(str2)

dp = [[0] * (str2_len + 1) for _ in range(str1_len + 1)]
max_length = 0
for i in range(str1_len):
	for j in range(str2_len):
		if str1[i] == str2[j]:
			dp[i + 1][j + 1] = dp[i][j] + 1
			max_length = max(max_length, dp[i+1][j+1])

print(max_length)
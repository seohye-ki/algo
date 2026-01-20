str1 = input()
str2 = input()
str3 = input()
len1 = len(str1)
len2 = len(str2)
len3 = len(str3)

dp = [[[0] * (len3 + 1) for _ in range(len2 + 1)] for _ in range(len1 + 1)]
for i in range(len1):
	for j in range(len2):
		for k in range(len3):
			if str1[i] == str2[j] == str3[k]:
				dp[i+1][j+1][k+1] = dp[i][j][k] + 1
			else:
				dp[i+1][j+1][k+1] = max(dp[i][j+1][k+1], dp[i+1][j][k+1], dp[i+1][j+1][k])
print(dp[len1][len2][len3])
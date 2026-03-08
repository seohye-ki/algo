import sys
from bisect import bisect_left
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

dp = []
for x in arr:
	pos = bisect_left(dp, x)
	if pos == len(dp):
		dp.append(x)
	else:
		dp[pos] = x

print(n - len(dp))
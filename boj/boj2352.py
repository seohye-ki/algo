import sys
from bisect import bisect_left

input = sys.stdin.readline

n = int(input())
ports = list(map(int, input().split()))

dp = []

for x in ports:
    pos = bisect_left(dp, x)
    if pos == len(dp):
        dp.append(x)
    else:
        dp[pos] = x

print(len(dp))
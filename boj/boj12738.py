import sys
from bisect import bisect_left

input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))

min_ends = []

for x in a:
    pos = bisect_left(min_ends, x)
    if pos == len(min_ends):
        min_ends.append(x)
    else:
        min_ends[pos] = x

print(len(min_ends))
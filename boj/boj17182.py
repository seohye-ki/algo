import sys
input = sys.stdin.readline
from itertools import permutations

N, start = map(int, input().split())
maps = []
for i in range(N):
	tmp = list(map(int, input().split()))
	maps.append(tmp)

for k in range(N):
	for i in range(N):
		for j in range(N):
			if maps[i][k] + maps[k][j] < maps[i][j]:
				maps[i][j] = maps[i][k] + maps[k][j]

min_time = float('inf')
others = [i for i in range(N) if i != start]

for perm in permutations(others):
	total = 0
	current = start

	for next in perm:
		total += maps[current][next]
		current = next
	
	min_time = min(min_time, total)

print(min_time)

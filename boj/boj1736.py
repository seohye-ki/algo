import sys
input = sys.stdin.readline
from collections import deque

N, M = map(int, input().split())
trash = deque([])
for i in range(N):
	line = list(map(int, input().split()))
	for j in range(M):
		if line[j] == 1:
			trash.append((i, j))

count = 0
T = len(trash)
visited = [False] * T

for i in range(T):
	if visited[i]:
		continue
	
	count += 1
	visited[i] = True
	r, c = trash[i]

	for j in range(i + 1, T):
		if visited[j]:
			continue

		if r <= trash[j][0] and c <= trash[j][1]:
			visited[j] = True
			r, c = trash[j][0], trash[j][1]

print(count)
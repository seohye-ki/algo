import sys
from collections import deque
input = sys.stdin.readline
N, M = map(int, input().split())

arr = [[] for _ in range(N)]
indegree = [0] * N
for _ in range(M):
	order = list(map(int, input().split()))
	for i in range(1, len(order) - 1):
		arr[order[i] - 1].append(order[i + 1] - 1)
		indegree[order[i + 1] - 1] += 1

que = deque([])
for i in range(N):
	if indegree[i] == 0:
		que.append(i)

answer = []
while que:
	tmp = que.popleft()
	answer.append(tmp + 1)

	for n in arr[tmp]:
		indegree[n] -= 1
		if indegree[n] == 0:
			que.append(n)

if any(indegree):
	print(0)
else:
	for n in answer:
		print(n)


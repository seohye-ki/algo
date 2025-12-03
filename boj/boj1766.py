import sys
input = sys.stdin.readline
import heapq

N, M = map(int, input().split())
indegree = [0] * (N + 1)
adjarr = [[] for _ in range(N + 1)]

for i in range(M):
	n1, n2 = map(int, input().split())
	indegree[n2] += 1
	adjarr[n1].append(n2)

pq = []
for i in range(1, N+1):
	if indegree[i] == 0:
		heapq.heappush(pq, i)

answer = []
while pq:
	n = heapq.heappop(pq)
	answer.append(n)

	for k in adjarr[n]:
		indegree[k] -= 1
		if indegree[k] == 0:
			heapq.heappush(pq, k)

print(*answer)
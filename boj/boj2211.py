import sys
input = sys.stdin.readline
import heapq

N, M = map(int, input().split())
adjlist = [[] for _ in range(N)]
for _ in range(M):
	a, b, w = map(int, input().split())
	adjlist[a-1].append((b-1, w))
	adjlist[b-1].append((a-1, w))

INF = float('inf')
dist = [INF] * N
dist[0] = 0
route = [-1] * N

pq = [(0, 0)]
while pq:
	w1, n1 = heapq.heappop(pq)
	if w1 > dist[n1]:
		continue

	for n2, w2 in adjlist[n1]:
		nd = w2 + dist[n1]
		if nd < dist[n2]:
			dist[n2] = nd
			heapq.heappush(pq, (nd, n2))
			route[n2] = n1

print(N - 1)
for i in range(1, N):
	print(i + 1, route[i] + 1)
import sys
import heapq
input = sys.stdin.readline

N, M = map(int, input().split())

arr = [[] for _ in range(N + 1)]
for _ in range(M):
	node1, node2, w = map(int, input().split())
	arr[node1].append((node2, w))
	arr[node2].append((node1, w))

INF = 10**9
dist = [INF] * (N + 1)

pq = []
dist[1] = 0
heapq.heappush(pq, (0, 1))

while pq:
	cost, node = heapq.heappop(pq)
	if dist[node] < cost:
		continue
	for n, w in arr[node]:
		if dist[node] + w < dist[n]:
			dist[n] = dist[node] + w
			heapq.heappush(pq, (dist[node] + w, n))

print(dist[N])
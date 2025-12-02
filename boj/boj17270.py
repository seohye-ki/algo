import sys
input = sys.stdin.readline
import heapq

V, M = map(int, input().split())
adjarr = [[] for _ in range(V)]
for _ in range(M):
	n1, n2, c = map(int, input().split())
	adjarr[n1-1].append((n2-1, c))
	adjarr[n2-1].append((n1-1, c))
J, S = map(int, input().split())

def dijkstra(dist, start):
	dist[start] = 0
	pq = [(0, start)]
	
	while pq:
		w1, n1 = heapq.heappop(pq)
		if dist[n1] < w1:
			continue

		for n2, w2 in adjarr[n1]:
			if dist[n1] + w2 < dist[n2]:
				dist[n2] = dist[n1] + w2
				heapq.heappush(pq, (dist[n2], n2))

INF = float('inf')
jdist = [INF] * V
sdist = [INF] * V
jdist[J-1] = 0
sdist[S-1] = 0
dijkstra(jdist, J-1)
dijkstra(sdist, S-1)

answer = V
time = INF
close = INF
# 최소값 찾기
for i in range(V):
	if i != J-1 and i != S-1:
		curr = jdist[i] + sdist[i]
		if curr < time:
			time = curr
		
for i in range(V):
	if i != J-1 and i != S-1: # 조건1
		curr = jdist[i] + sdist[i]
		if curr == time: # 조건2: 최소 합을 만족하는 노드들만
			if jdist[i] <= sdist[i]: # 조건3: 지헌이가 더 빨리 도착하거나 동시
				# 조건4: 지헌이에게 더 가까운 곳, 번호가 더 작은 곳
				if jdist[i] < close:
					close = jdist[i]
					answer = i
				elif jdist[i] == close and i < answer:
					answer = i

if answer == V:
	print(-1)
else:
	print(answer + 1)
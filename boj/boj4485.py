import heapq
import sys
input = sys.stdin.readline

problem = 1
while True:
	N = int(input())
	if N == 0:
		break

	maps = []
	for _ in range(N):
		line = list(map(int, input().split()))
		maps.append(line)
	
	INF = float('inf')
	dist = [[INF] * N for _ in range(N)]
	dist[0][0] = maps[0][0]

	pq = [(maps[0][0], 0, 0)]
	dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]
	while pq:
		cost, r, c = heapq.heappop(pq)
		if dist[r][c] < cost:
			continue

		for i in range(4):
			nr = r + dir[i][0]
			nc = c + dir[i][1]
			if 0 <= nr < N and 0 <= nc < N:
				if cost + maps[nr][nc] < dist[nr][nc]:
					dist[nr][nc] = cost + maps[nr][nc]
					heapq.heappush(pq, (cost + maps[nr][nc], nr, nc))
	print(f"Problem {problem}: {dist[N-1][N-1]}")
	problem += 1

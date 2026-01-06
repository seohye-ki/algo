import sys
input = sys.stdin.readline
sys.setrecursionlimit(1000000)

def dfs(curr, b, dist):
	if curr == b:
		return dist
	
	for n, w in adjList[curr]:
		if visited[n]:
			continue
		visited[n] = True
		result = dfs(n, b, dist + w)
		if result != None:
			return result
	return None

INF = float('inf')
N, M = map(int, input().split())
adjList = [[] for _ in range(N + 1)]

for _ in range(N - 1):
	a, b, w = map(int, input().split())
	adjList[a].append((b, w))
	adjList[b].append((a, w))

for _ in range(M):
	a, b = map(int, input().split())
	visited = [False] * (N + 1)
	visited[a] = True
	dist = dfs(a, b, 0)
	print(dist)
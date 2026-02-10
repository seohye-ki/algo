import sys
input = sys.stdin.readline
from collections import deque

N = int(input())
tree = [[] for _ in range(N + 1)]
for _ in range(N - 1):
	parent, child, w = map(int, input().split())
	tree[parent].append((child, w))
	tree[child].append((parent, w))

def bfs(start):
	q = deque()
	q.append(start)
	max_dist = 0
	dist = [-1] * (N + 1)
	dist[start] = 0
	far_node = start

	while q:
		node = q.popleft()

		for n, w in tree[node]:
			if dist[n] == -1:
				dist[n] = dist[node] + w
				q.append(n)

				if max_dist < dist[n]:
					max_dist = dist[n]
					far_node = n
	
	return far_node, max_dist

node1, d1 = bfs(1)
node2, d2 = bfs(node1)
print(d2)
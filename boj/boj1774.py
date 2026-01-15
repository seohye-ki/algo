import sys
input = sys.stdin.readline
sys.setrecursionlimit(1000000)
import math

def find(x):
	if parent[x] != x:
		parent[x] = find(parent[x])
	return parent[x]

def union(a, b):
	a_parent = find(a)
	b_parent = find(b)
	if a_parent != b_parent:
		parent[b_parent] = a_parent
		return True
	return False

N, M = map(int, input().split())
pos = []
for _ in range(N):
	a, b = map(int, input().split())
	pos.append((a, b))

parent = [i for i in range(N)]
edges = []
for i in range(N):
	for j in range(i + 1, N):
		x1, y1 = pos[i]
		x2, y2 = pos[j]
		dist = math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)
		edges.append((dist, i, j))
edges.sort()

for _ in range(M):
	a, b = map(int, input().split())
	union(a-1, b-1)

answer = 0
cnt = 0
for d, a, b in edges:
	if union(a, b):
		answer += d
		cnt += 1

		if cnt == N - 1:
			break
print(f"{answer:.2f}")
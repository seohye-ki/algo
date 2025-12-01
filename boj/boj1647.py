import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

import heapq
villages = []
N, M = map(int, input().split())
for _ in range(M):
	a, b, w = map(int, input().split())
	heapq.heappush(villages, (w, a, b))

parent = [i for i in range(N + 1)]

def find(x):
	if parent[x] != x:
		parent[x] = find(parent[x])
	return parent[x]

def union(a, b):
	root_a = find(a)
	root_b = find(b)

	if root_a != root_b:
		parent[root_b] = root_a
		return True
	return False

def count_group():
	group = set()
	for i in range(1, N + 1):
		group.add(find(i))
	return len(group)

max_w = 0
total = 0
select = 0
while villages:
	w, a, b = heapq.heappop(villages)

	if union(a, b):
		total += w
		select += 1
		max_w = max(max_w, w)
		if select == N - 1:
			break

print(total - max_w)
import sys
input = sys.stdin.readline
import heapq

V, E = map(int, input().split())
pq = []
for _ in range(E):
	a, b, w = map(int, input().split())
	heapq.heappush(pq, (w, a, b))

# 부모노드 찾기
def get_parent(parent, x):
	path = []
	while parent[x] != x:
		path.append(x)
		x = parent[x]
	for node in path:
		parent[node] = x
	return parent[x]

# 부모노드 합치기
def union_parent(parent, a, b):
	a = get_parent(parent, a)
	b = get_parent(parent, b)
	if a < b:
		parent[b] = a
	else:
		parent[a] = b

# 같은 트리인지 확인
def find_parent(parent, a, b):
	a = get_parent(parent, a)
	b = get_parent(parent, b)
	if a == b:
		return 1
	else:
		return 0

cycle = []
for i in range(V + 1):
	cycle.append(i)

total = 0
used = 0
while pq:
	w, a, b = heapq.heappop(pq)
	if find_parent(cycle, a, b): # 사이클O
		continue
	else: # 사이클X
		union_parent(cycle, a, b)
		total += w
		used += 1
		if used == V - 1:
			break
print(total)
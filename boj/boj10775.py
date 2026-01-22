import sys
input = sys.stdin.readline
sys.setrecursionlimit(1000000)

G = int(input())
P = int(input())
parent = [i for i in range(G + 1)]

def find(x):
	if parent[x] != x:
		parent[x] = find(parent[x])
	return parent[x]

planes = []
for _ in range(P):
	planes.append(int(input()))

answer = 0
for p in planes:
	gate = find(p)
	
	if gate == 0:
		break

	parent[gate] = gate - 1
	answer += 1

print(answer)
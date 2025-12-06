import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

N, M = map(int, input().split())
parents = [i for i in range(N)]

def find(x):
	if parents[x] != x:
		parents[x] = find(parents[x])
	return parents[x]

def union(n1, n2):
	n1_root = find(n1)
	n2_root = find(n2)

	if n1_root == n2_root:
		return False
	
	if n1_root <= n2_root:
		parents[n2_root] = n1_root
	else:
		parents[n1_root] = n2_root
	return True

flag = False
answer = 0
for i in range(M):
	n1, n2 = map(int, input().split())
	if not flag and not union(n1, n2):
		flag = True
		answer = i + 1
print(answer)
import sys
input = sys.stdin.readline
INF = 10**9

V, E = map(int, input().split())
arr = [[INF] * (V + 1) for _ in range(V + 1)]
for _ in range(E):
	node1, node2, d = map(int, input().split())
	arr[node1][node2] = d

#플루이드 워셜
for k in range(1, V+1):
	for i in range(1, V+1):
		for j in range(1, V+1):
			if arr[i][k] + arr[k][j] < arr[i][j]:
				arr[i][j] = arr[i][k] + arr[k][j]

# 최소 사이클 찾기
min_dist = INF
for i in range(1, V+1):
	if arr[i][i] < min_dist:
		min_dist = arr[i][i]

if min_dist == INF:
	print(-1)
else:
	print(min_dist)
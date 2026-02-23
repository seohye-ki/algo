import sys
input = sys.stdin.readline

N, C = map(int, input().split()) # N:마을수, C:트럭용량
M = int(input()) # M: 택배건수

deliveries = []
for _ in range(M):
	n1, n2, c = map(int, input().split())
	deliveries.append((n2, n1, c))
deliveries.sort()

answer = 0
capacity = [C] * (N + 1)
for n2, n1, c in deliveries:
	can = min(capacity[n1:n2])
	load = min(can, c)
	for i in range(n1, n2):
		capacity[i] -= load
	answer += load

print(answer)
import sys
input = sys.stdin.readline

N, C = map(int, input().split())
dist = []
for _ in range(N):
	dist.append(int(input()))
dist.sort()

answer = 0
left, right = 1, dist[-1] - dist[0]
while left <= right:
	mid = (left + right) // 2

	cnt = 1
	last = dist[0]

	for i in range(1, N):
		if mid <= dist[i] -  last:
			cnt += 1
			last = dist[i]
	
	if C <= cnt:
		left = mid + 1
		answer = mid
	else:
		right = mid - 1
print(answer)

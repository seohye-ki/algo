import sys
input = sys.stdin.readline
import heapq

N = int(input())
problems = []
for _ in range(N):
	d, r = map(int, input().split())
	problems.append((d, r))
problems.sort()

answer = 0
min_heap = []
for d, r in problems:
	heapq.heappush(min_heap, r)
	answer += r

	if d < len(min_heap):
		answer -= heapq.heappop(min_heap)
print(answer)
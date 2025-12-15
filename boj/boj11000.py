import sys
input = sys.stdin.readline

import heapq
N = int(input())
classes = []
for _ in range(N):
	s, e = map(int, input().split())
	classes.append((s, e))
classes.sort()

cnt = 1
end_time = [classes[0][1]]
for i in range(1, N):
	if end_time[0] <= classes[i][0]:
		heapq.heappop(end_time)
		heapq.heappush(end_time, classes[i][1])
	else:
		heapq.heappush(end_time, classes[i][1])
		cnt += 1

print(cnt)
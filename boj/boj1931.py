import heapq
N = int(input())
meetings = []
for i in range(N):
	s, e = map(int, input().split())
	meetings.append((e, s))

meetings.sort()

cnt = 0
curr = 0
for e, s in meetings:
	if curr <= s:
		cnt += 1
		curr = e

print(cnt)
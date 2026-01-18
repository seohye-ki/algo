import heapq
import sys
input = sys.stdin.readline

N = int(input())
oil = []
for _ in range(N):
	n, w = map(int, input().split())
	oil.append((n, w))

L, P = map(int, input().split())
oil.sort()

pq = []
curr_oil = P
curr_pos = 0
answer = 0
idx = 0
while curr_oil < L:

	while idx < N and oil[idx][0] <= curr_oil:
		heapq.heappush(pq, -oil[idx][1])
		idx += 1

	if not pq:
		print(-1)
		exit()
	
	answer += 1
	curr_oil += -heapq.heappop(pq)
print(answer)
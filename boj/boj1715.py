import sys
input = sys.stdin.readline
import heapq

N = int(input())
pq = []
for _ in range(N):
	num = int(input())
	heapq.heappush(pq, num)

total = 0
while pq:
	if len(pq) == 1:
		break

	num1 = heapq.heappop(pq)
	num2 = heapq.heappop(pq)
	total += (num1+num2)
	heapq.heappush(pq, num1+num2)

print(total)
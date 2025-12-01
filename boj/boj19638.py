import heapq
import sys
input = sys.stdin.readline

N, H, T = map(int, input().split())

pq = []
for _ in range(N):
	heapq.heappush(pq, -int(input()))

for i in range(T):
	tallest = -heapq.heappop(pq)
	if tallest < H:
		print("YES")
		print(i)
		break
	if 1 < tallest:
		heapq.heappush(pq, -(tallest//2))
	else:
		heapq.heappush(pq, -tallest)

else:
	tallest = -heapq.heappop(pq)
	if tallest < H:
		print("YES")
		print(T)
	else:
		print("NO")
		print(tallest)
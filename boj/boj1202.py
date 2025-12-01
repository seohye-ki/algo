import sys
input = sys.stdin.readline
import heapq

N, K = map(int, input().split())
jewelry = []
for _ in range(N):
	weight, price = map(int, input().split())
	jewelry.append((weight, price))
jewelry.sort()

bags = []
for _ in range(K):
	capacity = int(input())
	bags.append(capacity)
bags.sort()

available = []
total = 0
idx = 0

# 가방 작은 것부터 무게도 낮은 것부터
# 들어갈 수 있는 쥬얼리 모두 확인 그 후 가장 큰거 넣고 다음으로
for capacity in bags:
	while idx < N and jewelry[idx][0] <= capacity:
		weight, price = jewelry[idx]
		heapq.heappush(available, -price)
		idx += 1
	
	if available:
		max_price = -heapq.heappop(available)
		total += max_price

print(total)
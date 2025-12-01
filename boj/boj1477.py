# import heapq

# old, new, length = map(int, input().split())
# dist = []
# start = 1

# # 휴게소간 거리 배열 만들기
# if old != 0:
# 	stop = list(map(int, input().split()))
# 	stop.sort()
# 	print(stop)
# 	for d in stop:
# 		heapq.heappush(dist, -(d - start))
# 		start = d
# heapq.heappush(dist, -(length - start))
# print(dist)

# # 휴게소 세우기
# for _ in range(new):
# 	longest = -heapq.heappop(dist)
# 	if longest == 1:
# 		continue
# 	div = longest // 2
# 	mod = longest % 2
# 	heapq.heappush(dist, -div)
# 	heapq.heappush(dist, -(div + mod))

# print(f"바뀐후 {dist}")
# print(-heapq.heappop(dist))

old, new, length = map(int, input().split())
dist = []
start = 0

if old != 0:
	stop = list(map(int, input().split()))
	stop.sort()
	for d in stop:
		dist.append(d - start)
		start = d
dist.append(length - start)
dist.sort()

left, right = 1, dist[-1]
while left <= right:
	mid = (left + right) // 2
	need = 0
	for d in dist:
		if mid < d:
			need += ((d - 1) // mid)
	if new < need:
		left = mid + 1
	else:
		right = mid - 1
print(left)
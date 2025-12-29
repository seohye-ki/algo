import heapq
N, K = map(int, input().split())

bottles = []
tmp = N
L = 1
while tmp > 0:
	if tmp % 2 == 1:
		heapq.heappush(bottles, L)
	tmp //= 2
	L *= 2

answer = 0
while len(bottles) > K:
	a = heapq.heappop(bottles)
	b = heapq.heappop(bottles)

	if a == b:
		heapq.heappush(bottles, a*2)
	else:
		answer += (b - a)
		heapq.heappush(bottles, b*2)
print(answer)

# N, K = map(int, input().split())
# cnt = bin(N).count('1')

# answer = 0
# while cnt > K:
# 	add = N & -N
# 	answer += add
# 	N += add
# 	cnt = bin(N).count('1')
# print(answer)
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
counter = []
for _ in range(N):
	counter.append(int(input()))
counter.sort()

left, right = 1, counter[0] * M
answer = right

while left <= right:
	mid = (left + right) // 2

	total = 0
	for c in counter:
		total += mid // c
		if M <= total:
			break
	
	if M <= total:
		right = mid - 1
		answer = mid
	else:
		left = mid + 1

print(answer)
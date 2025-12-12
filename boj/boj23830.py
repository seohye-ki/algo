import bisect
N = int(input())
score = list(map(int, input().split()))
p, q, r, S = map(int, input().split())

score.sort()
total_score = sum(score)

def total(K):
	below = bisect.bisect_left(score, K)
	above = N - bisect.bisect_right(score, K+r)
	total = total_score + q * below - p * above
	return total

answer = -1
left = 1
right = 100001
while left <= right:
	mid = (left + right) // 2
	if S <= total(mid):
		answer = mid
		right = mid - 1
	else:
		left = mid + 1

print(answer)

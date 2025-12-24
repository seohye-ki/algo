N = int(input())
location = list(map(int, input().split()))
cost = list(map(int, input().split()))
fee = int(input())

bombs = sorted(zip(location, cost))

def all_explode(R):
	total = 0
	curr = bombs[0][1]
		
	for i in range(1, N):
		if bombs[i][0] - bombs[i-1][0] > R:
			total += curr
			if fee < total:
				return False
			curr = bombs[i][1]
		else:
			if bombs[i][1] < curr:
				curr = bombs[i][1]
	total += curr
	return total <= fee

left = 1
right = bombs[-1][0] - bombs[0][0]
answer = right
while left <= right:
    mid = (left + right) // 2
    if all_explode(mid):
        answer = mid
        right = mid - 1
    else:
        left = mid + 1

print(answer)
N = int(input())
numlist = list(map(int, input().split()))
numlist.sort()

answer = 0

for k in range(N):
	target = numlist[k]
	left = 0
	right = N - 1

	while left < right:
		if left == k:
			left += 1
			continue
		if right == k:
			right -= 1
			continue

		curr_sum = numlist[left] + numlist[right]

		if curr_sum == target:
			answer += 1
			break
		elif curr_sum < target:
			left += 1
		else:
			right -= 1

print(answer)
T = int(input())
for _ in range(T):
	str = input().strip()
	left = 0
	right = len(str) - 1
	answer = 0

	while left < right:
		if str[left] != str[right]:
			l1 = left + 1
			r1 = right
			flag1 = True
			while l1 < r1:
				if str[l1] != str[r1]:
					flag1 = False
					break
				l1 += 1
				r1 -= 1
			
			l2 = left
			r2 = right - 1
			flag2 = True
			while l2 < r2:
				if str[l2] != str[r2]:
					flag2 = False
					break
				l2 += 1
				r2 -= 1
			
			if flag1 or flag2:
				answer = 1
			else:
				answer = 2
			break
		left += 1
		right -= 1
	print(answer)
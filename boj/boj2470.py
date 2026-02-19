N = int(input())
liquid = list(map(int, input().split()))
liquid.sort()

left, right = 0, N-1
best = float('inf')
x1 = liquid[left]
x2 = liquid[right]

while left < right:
	tmp = liquid[left] + liquid[right]
	if abs(tmp) < best:
		best = abs(tmp)
		x1 = liquid[left]
		x2 = liquid[right]
	if tmp < 0:
		left += 1
	elif 0 < tmp:
		right -= 1
	else:
		break

print(x1, x2)
N = int(input())
arr = list(map(int, input().split()))
arr.sort()

close_zero = float('inf')
result = []

for i in range(N - 2):
	if i > 0 and arr[i] == arr[i - 1]:
		continue

	left = i + 1
	right = N - 1
	
	while left < right:
		tmp = arr[left] + arr[right] + arr[i]
	
		if abs(tmp) < close_zero:
			close_zero = abs(tmp)
			result = [arr[i], arr[left], arr[right]]
		
		if tmp < 0:
			left += 1
		elif 0 < tmp:
			right -= 1
		else:
			print(*result)
			exit()

print(*result)
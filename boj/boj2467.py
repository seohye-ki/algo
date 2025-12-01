import math
N = int(input())
arr = list(map(int, input().split()))

num1 = 0
num2 = 0

left = 0
right = N - 1
close_zero = float('inf')

while left < right:
	tmp = arr[left] + arr[right]
	if abs(tmp) < close_zero:
		close_zero = abs(tmp)
		num1 = arr[left]
		num2 = arr[right]
	
	if tmp < 0:
		left += 1
	elif 0 < tmp:
		right -= 1
	else:
		break

print(num1, num2)
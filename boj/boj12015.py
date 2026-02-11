from bisect import bisect_left

N = int(input())
arr = list(map(int, input().split()))

lis = []
for num in arr:
	pos = bisect_left(lis, num)
	if pos == len(lis):
		lis.append(num)
	else:
		lis[pos] = num
		
print(len(lis))
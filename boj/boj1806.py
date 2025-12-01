N, S = map(int, input().split())
arr = list(map(int, input().split()))

first = 0
last = 0
currSum = 0
minlen = 10000000000

while last < N:
	currSum += arr[last]
	while currSum >= S:
		minlen = min(minlen, last - first + 1)
		currSum -= arr[first]
		first += 1
	last += 1

if minlen == 10000000000:
	print(0)
else:
	print(minlen)


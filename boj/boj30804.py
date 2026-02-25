N = int(input())
tanghuru = list(map(int, input().split()))
arr = [0] * 10
total = 0
max_len = 0

first = 0
for last in range(N):
	if arr[tanghuru[last]] == 0:
		total += 1
	arr[tanghuru[last]] += 1

	while total > 2:
		arr[tanghuru[first]] -= 1
		if arr[tanghuru[first]] == 0:
			total -= 1
		first += 1
	
	max_len = max(max_len, last - first + 1)
print(max_len)
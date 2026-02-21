M, N = map(int, input().split())
arr = [True] * (N+1)
arr[0] = arr[1] = False

n = 2
while n * n <= N:
	if arr[n]:
		for j in range(n * n, N+1, n):
			arr[j] = False
	n += 1

for i in range(M, N+1):
	if arr[i]:
		print(i)
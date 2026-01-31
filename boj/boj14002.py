N = int(input())
arr = list(map(int, input().split()))

dp = [1] * N
prev = [-1] * N

for i in range(1, N):
    for j in range(i):
        if arr[j] < arr[i] and dp[i] < dp[j] + 1:
            dp[i] = dp[j] + 1
            prev[i] = j

max_length = max(dp)
print(max_length)

last_idx = dp.index(max_length)

lis = []
idx = last_idx
while idx != -1:
    lis.append(arr[idx])
    idx = prev[idx]

lis.reverse()
print(*lis)
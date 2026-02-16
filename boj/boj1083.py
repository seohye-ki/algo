n = int(input())
arr = list(map(int, input().split()))
s = int(input())

for i in range(n):
    if s == 0:
        break
    
    max_num = arr[i]
    max_idx = i

    for j in range(i + 1, min(n, i + s + 1)):
        if arr[j] > max_num:
            max_num = arr[j]
            max_idx = j

    while max_idx > i:
        arr[max_idx], arr[max_idx - 1] = arr[max_idx - 1], arr[max_idx]
        max_idx -= 1
        s -= 1

print(' '.join(map(str, arr)))
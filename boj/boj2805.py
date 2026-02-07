n, m = map(int, input().split())
trees = list(map(int, input().split()))

left, right = 0, max(trees)
result = 0

while left <= right:
    mid = (left + right) // 2

    total = 0
    for t in trees:
          if t > mid:
               total += (t - mid)
    
    if total >= m:
        result = mid
        left = mid + 1
    else:
        right = mid - 1

print(result)
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
days = [int(input()) for _ in range(N)]

left, right = max(days), sum(days)

while left < right:
    mid = (left + right) // 2
    
    count = 1
    remain = mid
    possible = True
    for cost in days:
        if cost > mid:
            possible = False
            break
        if remain < cost:
            count += 1
            remain = mid
        remain -= cost
    
    if possible and count <= M:
        right = mid
    else:
        left = mid + 1

print(left)
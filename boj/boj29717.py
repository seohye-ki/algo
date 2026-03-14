import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    total = N * (N + 1) // 2

    lo, hi = 0, 10**9
    while lo < hi:
        mid = (lo + hi + 1) // 2
        if mid * (mid + 1) <= total:
            lo = mid
        else:
            hi = mid - 1
    
    print(lo + 1)
N, K = map(int, input().split())
countries = list(map(int, input().split()))

lo, hi = 0, sum(countries) // K
while lo < hi:
    mid = (lo + hi + 1) // 2
    if sum(min(x, mid) for x in countries) >= mid * K:
        lo = mid
    else:
        hi = mid - 1

print(lo)
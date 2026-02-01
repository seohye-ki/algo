n, k = map(int, input().split())
heights = list(map(int, input().split()))

if k >= n:
    print(0)
else:
    diff = []
    for i in range(n - 1):
        diff.append(heights[i + 1] - heights[i])

    diff.sort(reverse=True)

    total = heights[-1] - heights[0]
    for i in range(k - 1):
        total -= diff[i]
    
    print(total)
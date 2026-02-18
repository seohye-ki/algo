import sys
import bisect
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N, M = map(int, input().split())
    requests = []
    for _ in range(M):
        a, b = map(int, input().split())
        requests.append((b, a))
    
    requests.sort()
    available = list(range(1, N + 1))
    
    count = 0
    for b, a in requests:
        idx = bisect.bisect_left(available, a)
        if idx < len(available) and available[idx] <= b:
            count += 1
            available.pop(idx)
    
    print(count)
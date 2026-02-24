import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    applicants = []
    for _ in range(N):
        t1, t2 = map(int, input().split())
        applicants.append((t1, t2))
    applicants.sort()
    
    count = 0
    min_t2 = float('inf')
    
    for t1, t2 in applicants:
        if t2 < min_t2:
            min_t2 = t2
            count += 1
    
    print(count)
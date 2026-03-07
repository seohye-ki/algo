import sys
input = sys.stdin.readline

n = int(input())
budgets = list(map(int, input().split()))
m = int(input())

if sum(budgets) <= m:
    print(max(budgets))
else:
    left, right = 1, max(budgets)
    answer = 0

    while left <= right:
        mid = (left + right) // 2

        total = sum(min(b, mid) for b in budgets)

        if total <= m:
            answer = mid
            left = mid + 1
        else:
            right = mid - 1

    print(answer)
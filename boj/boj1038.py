from itertools import combinations

N = int(input())
decreasing_nums = []

for i in range(1, 11):
    for comb in combinations(range(10), i):
        comb = sorted(list(comb), reverse=True)
        decreasing_nums.append(int("".join(map(str, comb))))

decreasing_nums.sort()

if N >= len(decreasing_nums):
    print(-1)
else:
    print(decreasing_nums[N])
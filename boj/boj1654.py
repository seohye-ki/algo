k, n = map(int, input().split())
lans = []
for _ in range(k):
    lans.append(int(input()))

left = 1
right = max(lans)
answer = 0

while left <= right:
    mid = (left + right) // 2

    count = 0
    for lan in lans:
        count += lan // mid

    if count >= n:
        answer = mid
        left = mid + 1
    else:
        right = mid - 1

print(answer)

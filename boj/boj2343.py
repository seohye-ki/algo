n, m = map(int, input().split())
lectures = list(map(int, input().split()))

left = max(lectures)
right = sum(lectures)

answer = right

while left <= right:
    mid = (left + right) // 2
    count = 1
    total = 0
    
    for lecture in lectures:
        if total + lecture > mid:
            count += 1
            total = lecture
        else:
            total += lecture

    if count <= m:
        answer = mid
        right = mid - 1
    else:
        left = mid + 1

print(answer)
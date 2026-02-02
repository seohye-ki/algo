n, r, c = map(int, input().split())

answer = 0

while n > 0:
    half = 2 ** (n - 1)

    if r < half and c < half: # 1사분면
        pass
    elif r < half and c >= half: # 2사분면
        answer += half * half
        c -= half
    elif r >= half and c < half: # 3사분면
        answer += 2 * half * half
        r -= half
    else:
        answer += 3 * half * half # 4사분면
        r -= half
        c -= half
    
    n -= 1

print(answer)
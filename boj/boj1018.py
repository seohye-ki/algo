N, M = map(int, input().split())
board = [input() for _ in range(N)]

ans = 64

for r in range(N - 7):
    for c in range(M - 7):
        count = 0
        for i in range(8):
            for j in range(8):
                color = 'W' if (i + j) % 2 == 0 else 'B'
                if board[r + i][c + j] != color:
                    count += 1
        ans = min(ans, count, 64 - count)

print(ans)
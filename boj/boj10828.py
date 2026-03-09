import sys
input = sys.stdin.readline

N = int(input())
paper = [list(map(int, input().split())) for _ in range(N)]

white = 0
blue = 0

stack = [(0, 0, N)]

while stack:
    x, y, size = stack.pop()
    
    color = paper[x][y]
    same = True
    for i in range(x, x + size):
        for j in range(y, y + size):
            if paper[i][j] != color:
                same = False
                break
        if not same:
            break
    
    if same:
        if color == 0:
            white += 1
        else:
            blue += 1
    else:
        half = size // 2
        stack.append((x, y, half))
        stack.append((x, y + half, half))
        stack.append((x + half, y, half))
        stack.append((x + half, y + half, half))

print(white)
print(blue)
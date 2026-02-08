N, L = map(int, input().split())
hole = []
for _ in range(N):
    start, end = map(int, input().split())
    hole.append((start, end))

hole.sort()

count = 0
curr = 0

for start, end in hole:
    if curr > start:
        start = curr

    if start < end:
        length = end - start
        need = (length + L - 1) // L
        count += need
        curr = start + need * L

print(count)
import sys
input = sys.stdin.readline

N = int(input())
assignments = []
for _ in range(N):
	d, w = map(int, input().split())
	assignments.append((w, d))
assignments.sort(reverse=True)

score = 0
day = [False] * 1001
for w, d in assignments:
	i = d
	while 0 < i:
		if not day[i]:
			day[i] = True
			score += w
			break
		i -= 1
print(score)
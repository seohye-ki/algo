import sys
input = sys.stdin.readline

N, M, H = map(int, input().split())
milks = []
home_x = 0
home_y = 0
for i in range(N):
	line = list(map(int, input().split()))
	for j in range(N):
		if line[j] == 2:
			milks.append((i, j))
		elif line[j] == 1:
			home_x = i
			home_y = j

answer = 0
milk_len = len(milks)
def recursion(x, y, hp, visited, cnt):
	global answer
	if cnt + (milk_len - sum(visited)) <= answer:
		return
	
	dist = abs(x - home_x) + abs(y - home_y)
	if hp >= dist:
		answer = max(answer, cnt)
	
	for i in range(len(milks)):
		if not visited[i]:
			milk_x, milk_y = milks[i]
			dist = abs(x - milk_x) + abs(y - milk_y)

			if hp >= dist:
				visited[i] = True
				recursion(milk_x, milk_y, hp - dist + H, visited, cnt + 1)
				visited[i] = False
	
visited = [False] * len(milks)
recursion(home_x, home_y, M, visited, 0)
print(answer)
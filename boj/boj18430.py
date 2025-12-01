import sys
input = sys.stdin.readline

N, M = map(int, input().split())
maps = []
for _ in range(N):
	oneline = list(map(int, input().split()))
	maps.append(oneline)

# 부메랑 가능 모양
boomerangs = [
	[(0, 0), (0, -1), (1, 0)], # 좌 하
	[(0, 0), (0, -1), (-1, 0)], # 좌 상
	[(0, 0), (0, 1), (-1, 0)], # 우 상
	[(0, 0), (0, 1), (1, 0)] # 우 하
	]

maximum = 0
visited = [[False] * M for _ in range(N)]

def dfs(i, j, current_sum):
	global maximum
	if i == N: # 마지막인 경우
		maximum = max(maximum, current_sum)
		return
	
	ni = i
	nj = j + 1
	if M <= nj:
		nj = 0
		ni += 1

	if visited[i][j]: # 이미 사용중인 경우
		dfs(ni, nj, current_sum)
		return
	
	# 1. 현재칸을 중심으로 사용하지 않을때
	dfs(ni, nj, current_sum)

	# 2. 중심으로 사용할때
	for k in range(4):
		can = True
		position = []

		for dr, dc in boomerangs[k]:
			nr = i + dr
			nc = j + dc
			if 0 <= nr < N and 0 <= nc < M and not visited[nr][nc]:
				position.append((nr, nc))
			else:
				can = False
				break
		
		if can:
			total = 0
			for idx, (nr, nc) in enumerate(position):
				visited[nr][nc] = True
				if idx == 0:
					total += (maps[nr][nc] * 2)
				else:
					total += maps[nr][nc]
		
			dfs(ni, nj, current_sum + total)

			for nr, nc in position:
				visited[nr][nc] = False

dfs(0, 0, 0)
print(maximum)
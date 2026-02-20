from collections import deque
N, K = map(int, input().split())
INF = float('inf')

dq = deque()
dq.append((0, N))
dist = [INF] * 100001
dist[N] = 0

while dq:
	time, pos = dq.popleft()

	if time > dist[pos]:
		continue

	if pos == K:
		print(time)
		break

	if pos * 2 < 100001 and dist[pos*2] > time:
		dist[pos*2] = time
		dq.appendleft((time, pos*2))
	
	if pos + 1 < 100001 and dist[pos+1] > time + 1:
		dist[pos+1] = time + 1
		dq.append((time+1, pos+1))

	if 0 <= pos - 1 and dist[pos-1] > time + 1:
		dist[pos-1] = time + 1
		dq.append((time+1, pos-1))
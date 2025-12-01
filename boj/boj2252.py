# from collections import deque

# N, M = map(int, input().split())
# # 진입차수, 인접배열 만들기
# inDegree = [0] * N
# graph = [[] for _ in range(N)]
# for _ in range(M):
# 	A, B = map(int, input().split())
# 	inDegree[B - 1] += 1
# 	graph[A - 1].append(B - 1)

# answer = []
# que = deque([])
# # 잔입차수 0인거 넣기
# for i in range(N):
# 	if inDegree[i] == 0:
# 		que.append(i)

# # 큐가 빌때까지 원소하나 빼서 그거랑 연결된거 차수 1씩 마이너스 다시 0인거 넣기
# for i in range(N):
# 	tmp = que.popleft()
# 	answer.append(tmp + 1)
# 	# 연결된거 진입차수 -1
# 	for n in graph[tmp]:
# 		inDegree[n] -= 1
# 		if inDegree[n] == 0:
# 			que.append(n)

# print(*answer)
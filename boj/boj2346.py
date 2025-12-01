# from collections import deque

# N = int(input())
# balloons = list(map(int, input().split()))
# que = deque(range(N))

# answer = ""
# for _ in range(N):
# 	idx = que.popleft()
# 	answer = answer + str(idx + 1) + " "
# 	turns = balloons[idx]
# 	if 0 < balloons[idx]:
# 		turns -= 1
# 	que.rotate(-1 * turns)

# print(answer)

from collections import deque

N = int(input())
moves = list(map(int, input().split()))
que = deque(enumerate(moves, start=1))

answer = []

while que:
	idx, move = que.popleft()
	answer.append(idx)

	if not que:
		break
	
	if 0 < move:
		move -= 1
	que.rotate(-move)

print(*answer)
# import sys
# input = sys.stdin.readline

# N = int(input())
# K = int(input())
# arr = list(map(int, input().split()))

# if K >= N:
# 	print(0)
# 	exit()

# arr.sort()

# dist = []
# for i in range(N - 1):
# 	dist.append(arr[i + 1] - arr[i])

# for i in range(K - 1):
# 	if max(dist) > -1:
# 		max_index = dist.index(max(dist))
# 		dist[max_index] = -1

# answer = 0
# for num in dist:
# 	if num == -1:
# 		continue
# 	answer += num

# print(answer)

import sys
input = sys.stdin.readline

N = int(input())
K = int(input())
arr = list(map(int, input().split()))

# K가 N보다 크거나 같으면 정답은 0
if K >= N:
    print(0)
    exit()

arr.sort()

dist = []
for i in range(N - 1):
    dist.append(arr[i + 1] - arr[i])

# 간단하게 정렬 후 필요한 부분만 합산
dist.sort()  # 오름차순 정렬
answer = sum(dist[:N-K])  # 작은 값들만 더함

print(answer)
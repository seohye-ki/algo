N = int(input())
arr = list(map(int, input().split()))

answer = [0] * N
for i in range(N):
	tmp = 0
	for j in range(N):
		if tmp == arr[i]:
			while answer[j] != 0:
				j += 1
			answer[j] = i + 1
			break
		if answer[j] == 0:
			tmp += 1

print(*answer)

# N = int(input())
# arr = list(map(int, input().split()))
# answer = []

# # 큰 키부터
# for i in range(N-1, -1, -1):
#     answer.insert(arr[i], i+1)

# print(*answer)

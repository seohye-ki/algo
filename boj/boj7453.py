import sys
input = sys.stdin.readline

N = int(input())
A, B, C, D = [], [], [], []
for _ in range(N):
	a, b, c, d = map(int, input().split())
	A.append(a)
	B.append(b)
	C.append(c)
	D.append(d)

AB = []
for i in range(N):
	for j in range(N):
		AB.append(A[i] + B[j])

CD = []
for i in range(N):
	for j in range(N):
		CD.append(C[i] + D[j])

AB.sort()
CD.sort()

answer = 0
ab_idx = 0
cd_idx = len(CD) - 1
while ab_idx < len(AB) and 0 <= cd_idx:
	total = AB[ab_idx] + CD[cd_idx]
	if total == 0:
		ab = AB[ab_idx]
		cd = CD[cd_idx]
		ab_cnt = 0
		cd_cnt = 0
		while ab_idx < len(AB) and AB[ab_idx] == ab:
			ab_cnt += 1
			ab_idx += 1
		while 0 <= cd_idx and CD[cd_idx] == cd:
			cd_cnt += 1
			cd_idx -= 1
		answer += (ab_cnt * cd_cnt)
	elif total < 0:
		ab_idx += 1
	else:
		cd_idx -= 1

print(answer)

# import sys
# input = sys.stdin.readline
# from collections import Counter

# N = int(input())
# A = []
# B = []
# C = []
# D = []
# for _ in range(N):
# 	a, b, c, d = map(int, input().split())
# 	A.append(a)
# 	B.append(b)
# 	C.append(c)
# 	D.append(d)

# AB = []
# for i in range(N):
# 	for j in range(N):
# 		AB.append(A[i] + B[j])

# CD = []
# for i in range(N):
# 	for j in range(N):
# 		CD.append(C[i] + D[j])

# CD_counter = Counter(CD)

# answer = 0
# for num in AB:
# 	target = -num
# 	answer += CD_counter[target]
# print(answer)
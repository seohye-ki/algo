N, K = map(int, input().split())
num = input()
cnt = 0
answer = [int(num[0])]
for i in range(1, N):
	n = int(num[i])
	
	# K개 지우기 완료
	if cnt == K:
		answer.append(n)
		continue

	flag = True
	for j in range(len(answer)-1, -1, -1):	
		if cnt == K or not flag: # K개 지우기 완료 또는 더이상 볼 필요 없음
			break

		# 비교
		if answer[j] < n:
			answer.pop()
			cnt += 1
		else:
			flag = False
	
	answer.append(n)

while cnt < K:
	answer.pop()
	cnt += 1

print(''.join(map(str, answer)))
import sys
input = sys.stdin.readline

N, M, B = map(int, input().split())
ground = [0] * 257
for _ in range(N):
	line = list(map(int, input().split()))
	for n in line:
		ground[n] += 1

sum_arr = [0] * 258
cnt_arr = [0] * 258
for i in range(257):
	sum_arr[i+1] = sum_arr[i] + ground[i] * i # 지금까지 블록 수 총합
	cnt_arr[i+1] = cnt_arr[i] + ground[i] # 지금까지 구역 수 총합

best_time = float('inf')
best_height = 0
for h in range(257):
	# 높은 칸 제거
	remove = (sum_arr[257] - sum_arr[h+1]) - (cnt_arr[257] - cnt_arr[h+1]) * h

	# 낮은 칸 메꿈
	add = cnt_arr[h] * h - sum_arr[h]

	if add <= B + remove:
		time = remove * 2 + add
		if time < best_time or (time == best_time and h > best_height):
			best_time = time
			best_height = h

print(best_time, best_height)
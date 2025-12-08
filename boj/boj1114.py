L, K, C = map(int, input().split())
can = set(list(map(int, input().split())))
pos = [0] + sorted(can) + [L]

def can_cut(x):
	idx = 0
	cnt = 0
	for i in range(len(pos)):
		if pos[i] - pos[idx] > x:
			if i - 1 == idx: #이미 자른 위치
				return False
			if pos[i] - pos[i-1] > x: #바로 다음 자를 수 있는 위치에서 잘라도 x보다 큼
				return False
			cnt += 1
			idx = i - 1
	return cnt <= C

answer = L
left = 1
right = L
while left <= right:
	mid = (left + right) // 2
	if can_cut(mid):
		answer = mid
		right = mid - 1
	else:
		left = mid + 1

first = 0
idx = len(pos) - 1
cnt = 0
flag = False
for i in range(len(pos)-2, -1, -1):
	if pos[idx] - pos[i] > answer:
		if pos[idx] - pos[i + 1] == answer:
			flag = True
		first = pos[i + 1]
		idx = i + 1
		cnt += 1
if flag and cnt < C:
	first = pos[1]

print(answer, first)
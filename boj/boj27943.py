import sys
input = sys.stdin.readline

N = int(input())

mid = (N + 1) // 2
print("? " + str(mid), flush=True)
gaji = input()

# 가지가 변하는 왼쪽 지점 찾기
left = 1
right = mid
while left < right:
	m = (left + right) // 2
	print("? " + str(m), flush=True)
	res = input()
	if res == gaji:
		right = m
	else:
		left = m + 1
min_idx = left

# 가지가 변하는 오른쪽 지점 찾기
left = mid
right = N
while left < right:
	m = (left + right + 1) // 2
	print("? " + str(m), flush=True)
	res = input()
	if res == gaji:
		left = m
	else:
		right = m - 1
max_idx = right
print("! " + str(min_idx) + " " + str(max_idx), flush=True)
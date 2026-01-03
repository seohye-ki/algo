import sys
input = sys.stdin.readline

N = int(input())
flowers = []
days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

for _ in range(N):
	start_month, start_day, end_month, end_day = map(int, input().split())
	start = sum(days[:start_month]) + start_day
	end = sum(days[:end_month]) + end_day
	flowers.append((start, end))
flowers.sort()

start = 60 # 3/1
end = 334 # 11/30

answer = 0
curr = start
idx = 0
while curr <= end:
	next_end = 0
	start_idx = idx
	while idx < N and flowers[idx][0] <= curr:
		next_end = max(next_end, flowers[idx][1])
		idx += 1

	if next_end <= curr:
		print(0)
		exit()
	
	curr = next_end
	answer += 1
print(answer)
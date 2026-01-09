import sys
input = sys.stdin.readline

N = int(input())
villages = []
total_people = 0
for _ in range(N):
	loc, people = map(int, input().split())
	total_people += people
	villages.append((loc, people))
villages.sort()

tmp = 0
for loc, n in villages:
	tmp += n
	if tmp >= (total_people + 1) // 2:
		print(loc)
		break

from itertools import permutations

N = int(input())
innings = []
for _ in range(N):
	innings.append(list(map(int, input().split())))

max_score = 0
for perm in permutations(range(1, 9)):
	order = list(perm[:3]) + [0] + list(perm[3:])
	score = 0
	player = 0
	
	for i in range(N):
		out = 0
		base = [False, False, False]

		while out < 3:
			result = innings[i][order[player]]

			if result == 0:
				out += 1
			elif result == 1:
				score += base[2]
				base[2] = base[1]
				base[1] = base[0]
				base[0] = True
			elif result == 2:
				score += (base[2] + base[1])
				base[2] = base[0]
				base[1] = True
				base[0] = False
			elif result == 3:
				score += (base[2] + base[1] + base[0])
				base[2] = True
				base[1] = False
				base[0] = False
			elif result == 4:
				score += (base[0] + base[1] + base[2] + 1)
				base = [False, False, False]
			player = (player + 1) % 9

	max_score = max(max_score, score)
print(max_score)
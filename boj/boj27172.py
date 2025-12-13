N = int(input())
cards = list(map(int, input().split()))
scores = [0] * N

players = {}
for i in range(N):
	players[cards[i]] = i

max_card = max(cards)
for i in range(N):
	curr = cards[i]

	tmp = curr * 2
	while tmp <= max_card:
		if tmp in players:
			scores[i] += 1
			scores[players[tmp]] -= 1
		tmp += curr

print(*scores)
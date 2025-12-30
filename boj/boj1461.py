N, M = map(int, input().split())
locations = list(map(int, input().split()))
minus = []
plus = []
for n in locations:
	if n < 0:
		minus.append(abs(n))
	else:
		plus.append(n)

minus.sort(reverse=True)
plus.sort(reverse=True)

total = 0
for i in range(0, len(minus), M):
	total += (minus[i] * 2)
for i in range(0, len(plus), M):
	total += (plus[i] * 2)

max_dist = 0
if minus:
	max_dist = minus[0]
if plus:
	max_dist = max(max_dist, plus[0])
total -= max_dist
print(total)
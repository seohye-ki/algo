import sys
input = sys.stdin.readline
N = int(input())
pos = []
neg = []
for _ in range(N):
	num = int(input())
	if num <= 0:
		neg.append(num)
	else:
		pos.append(num)

pos.sort(reverse=True)
neg.sort()

total = 0
idx = 0
pos_len = len(pos)
while idx < pos_len:
	if pos_len <= idx + 1:
		total += pos[idx]
		break
	else:
		if pos[idx] == 1 or pos[idx+1] == 1:
			total += (pos[idx] + pos[idx+1])
		else:
			total += (pos[idx] * pos[idx+1])
	idx += 2

idx = 0
neg_len = len(neg)
while idx < neg_len:
	if neg_len <= idx + 1:
		total += neg[idx]
		break
	else:
		total += (neg[idx] * neg[idx+1])
	idx += 2

print(total)
N = int(input())
str = input()
str_len = len(str)

def next_pos(idx, length):
	if idx % 2 == 0:
		return idx // 2
	else:
		return length - 1 - (idx // 2)
		
visited = [False] * str_len
answer = [''] * str_len

for start in range(str_len):
	if visited[start]:
		continue

	cycle = []
	idx = start
	while not visited[idx]:
		visited[idx] = True
		cycle.append(idx)
		idx = next_pos(idx, str_len)
	
	cycle_len = len(cycle)
	for i in cycle:
		pos = cycle.index(i)
		k = (pos + N) % cycle_len
		answer[cycle[k]] = str[i]
print(''.join(answer))

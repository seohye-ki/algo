S, P = map(int, input().split())
line = input()
condition = list(map(int, input().split())) # A-C-G-T 순
DNA = [0] * S
for i, c in enumerate(line):
	if c == 'A':
		DNA[i] = 0
	elif c == 'C':
		DNA[i] = 1
	elif c == 'G':
		DNA[i] = 2
	else:
		DNA[i] = 3

answer = 0
curr = [0] * 4
for i in range(P):
	curr[DNA[i]] += 1
if condition[0] <= curr[0] and condition[1] <= curr[1] and condition[2] <= curr[2] and condition[3] <= curr[3]: 
	answer += 1

left = 0
for right in range(P, S):
	curr[DNA[left]] -= 1
	curr[DNA[right]] += 1

	if condition[0] <= curr[0] and condition[1] <= curr[1] and condition[2] <= curr[2] and condition[3] <= curr[3]: 
		answer += 1
	
	left += 1

print(answer)
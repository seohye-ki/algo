import sys
input = sys.stdin.readline

N, d, k, c = map(int, input().split()) # N:접시 수 d:초밥 가짓수 k:연속 접시 수 c:쿠폰 초밥
sushi = []
for _ in range(N):
	sushi.append(int(input()))

freq = {}
for i in range(k):
	freq[sushi[i]] = freq.get(sushi[i], 0) + 1
freq[c] = freq.get(c, 0) + 1
max_type = len(freq)

for i in range(N):
	freq[sushi[i]] -= 1
	if freq[sushi[i]] == 0:
		del freq[sushi[i]]
	
	next = (i + k) % N
	freq[sushi[next]] = freq.get(sushi[next], 0) + 1

	if max_type < len(freq):
		max_type = len(freq)
print(max_type)
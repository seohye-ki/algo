import sys
input = sys.stdin.readline

N = int(input())
words = []
for _ in range(N):
	word = input().strip()
	words.append(word)

weight = {}
for word in words:
	length = len(word)
	i = 0
	for c in word:
		pos = length - 1 - i
		weight[c] = weight.get(c, 0) + (10 ** pos)
		i += 1

alpabet = []
for c, n in weight.items():
	alpabet.append(n)
alpabet.sort(reverse=True)

answer = 0
num = 9
for n in alpabet:
	answer += (n * num)
	num -= 1
print(answer)
class Trie:
	def __init__(self):
		self.head = {}

	def add(self, word):
		cur = self.head
		for c in word:
			if c not in cur:
				cur[c] = {}
			cur = cur[c]
		cur['*'] = True
	
	def search(self, word):
		cur = self.head
		for c in word:
			if c not in cur:
				return False
			cur = cur[c]
		return True
	
import sys
input = sys.stdin.readline
N, M = map(int, input().split())

trie = Trie()

for _ in range(N):
	word = input().strip()
	trie.add(word)

answer = 0
for _ in range(M):
	word = input().strip()
	if trie.search(word):
		answer += 1

print(answer)
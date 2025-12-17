class Trie:
	def __init__(self):
		self.head = {}
	
	def add(self, word):
		curr = self.head
		for c in word:
			if c not in curr:
				curr[c] = {}
			curr = curr[c]
		curr['*'] = True
	
	def typing(self, word):
		curr = self.head
		cnt = 1
		curr = curr[word[0]]
		for i in range(1, len(word)):
			# 단어 2개 이상이거나 단어끝인데 더 긴 단어도 있음
			if 1 < len(curr.keys()):
				cnt += 1
			curr = curr[word[i]]
		return cnt

import sys
input = sys.stdin.readline

while True:
	try:		
		N = int(input())
		trie = Trie()
		words = []

		for _ in range(N):
			word = input().strip()
			trie.add(word)
			words.append(word)
		
		total = 0
		for w in words:
			total += trie.typing(w)

		print(f"{total / N:.2f}")
	except:
		break


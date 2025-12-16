class Trie:
	def __init__(self):
		self.head = {}
	
	def add(self, word):
		cur = self.head
		for c in word:
			if c not in cur:
				cur[c] = {}
			cur = cur[c]
			if '*' in cur: # 접두어 존재
				return False
		cur['*'] = True
		return True	

import sys
input = sys.stdin.readline
T = int(input())
for _ in range(T):
	N = int(input())
	words = []
	for _ in range(N):
		words.append(input().strip())
	
	words.sort(key=len)

	trie = Trie()
	flag = True
	for word in words:
		if not trie.add(word):
			flag = False
			break
	print('YES' if flag else 'NO')
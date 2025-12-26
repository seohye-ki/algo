class Trie:
	def __init__(self):
		self.head = {}
	
	def add(self, str):
		curr = self.head
		for str in strs:
			if str not in curr:
				curr[str] = {}
			curr = curr[str]
		curr['*'] = True

	def print_trie(self, node=None, depth=0):
		if node == None:
			node = self.head
		
		items = sorted(node.items())
		for key, value in items:
			if key != '*':
				print('--' * depth + key)
				self.print_trie(value, depth+1)


import sys
input = sys.stdin.readline
N = int(input())
trie = Trie()
for _ in range(N):
	strs = list(input().split())
	strs = strs[1:]
	trie.add(strs)
trie.print_trie()
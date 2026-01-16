import sys
input = sys.stdin.readline

class Trie():
	def __init__(self):
		self.head = {}

	def add(self, string):
		curr = self.head
		for c in string:
			if c not in curr:
				curr[c] = {}
			curr = curr[c]
		curr['*'] = True
	
	def find_alias(self, string):
		curr = self.head
		alias = ''
		for c in string:
			alias += c
			if c not in curr:
				return alias
			curr = curr[c]
		return None

N = int(input())
names = {} # 중복닉네임 수
trie = Trie()
for _ in range(N):
	string = input().strip()
	names[string] = names.get(string, 0) + 1
	alias = trie.find_alias(string)
	trie.add(string)
	if alias is None:
		if names[string] == 1:
			alias = string
		else:
			alias = string + str(names[string])
	print(alias)
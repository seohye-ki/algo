from itertools import combinations
L, C = map(int, input().split())
words = list(input().split())
vowels = ['a', 'e', 'i', 'o', 'u']
words.sort()
for comb in combinations(words, L):
	vowel_cnt = 0
	for c in comb:
		if c in vowels:
			vowel_cnt += 1			
	consonant_cnt = L - vowel_cnt

	if 1 <= vowel_cnt and 2 <= consonant_cnt:
		print(''.join(comb))
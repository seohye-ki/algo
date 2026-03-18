import sys
from collections import Counter

input = sys.stdin.readline

N, M = map(int, input().split())

words = []
for _ in range(N):
    word = input().strip()
    if len(word) >= M:
        words.append(word)

count = Counter(words)

def sort_key(word):
    return (-count[word], -len(word), word)

result = sorted(count.keys(), key=sort_key)

print('\n'.join(result))
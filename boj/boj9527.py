def count(n):
	total = 0

	for i in range(n.bit_length()):
		# 완전한 사이클 = 사이클이 몇번 반복되는지 * 사이클 내 1의 갯수
		total += ((n+1) // (2 ** (i+1)) * (2 ** i))
		# 남은거 = 완전한 사이클 제외 나머지 - 사이클 내 0의 갯수
		total += max(0, ((n+1) % (2 ** (i+1)) - (2 ** i)))
	
	return total

A, B = map(int, input().split())
print(count(B) - count(A-1))
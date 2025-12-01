import sys

def main():
	input = sys.stdin.readline
	M, N = map(int, input().split())
	cookies = list(map(int, input().split()))

	left = 1
	right = max(cookies)
	answer = 0
	while left <= right:
		mid = (left + right) // 2
		total = 0
		for length in cookies:
			total += length // mid
			if M <= total:
				break
		if M <= total:
			left = mid + 1
			answer = mid
		else:
			right = mid - 1
	print(answer)

if __name__ == "__main__":
	main()

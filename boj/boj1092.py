N = int(input())
cranes = list(map(int, input().split()))
cranes.sort(reverse=True)
M = int(input())
boxes = list(map(int, input().split()))
boxes.sort(reverse=True)

if boxes[0] > cranes[0]:
	print(-1)
else:
	answer = 0
	while boxes:
		answer += 1
		for c in cranes:
			for i in range(len(boxes)):
				if c >= boxes[i]:
					boxes.pop(i)
					break
	print(answer)
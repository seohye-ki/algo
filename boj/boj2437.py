N = int(input())
num_list = list(map(int, input().split()))
num_list.sort()

num = 1
for n in num_list:
	if n > num:
		break
	num += n
print(num)
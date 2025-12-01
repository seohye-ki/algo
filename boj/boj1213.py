# from collections import defaultdict

# name = list(input())

# counter = defaultdict(int)
# for x in name:
# 	counter[x] += 1

# if len(name) % 2 == 0:
# 	# 모든 밸류값이 짝수여야 가능
# 	for value in counter.values():
# 		# 하나라도 홀수라면
# 		if value % 2 != 0:
# 			print("I'm Sorry Hansoo")
# 			exit(0)
# 	# 짝수 팰린드롬 만들기
# 	sorted_counter = sorted(counter.items(), key=lambda x: x[0])
# 	start = 0
# 	end = len(name) - 1
# 	for key, value in sorted_counter:
# 		while value != 0:
# 			name[start] = key
# 			name[end] = key
# 			start += 1
# 			end -= 1
# 			value -= 2
# 	answer = ''.join(name)
# 	print(answer)
# else:
# 	flag = 0
# 	# 한개만 홀수여야 가능
# 	for value in counter.values():
# 		# 홀수라면
# 		if value % 2 != 0:
# 			if flag == 0:
# 				flag = 1
# 			else:
# 				print("I'm Sorry Hansoo")
# 				exit(0)
# 	# 홀수 팰린드롬 만들기
# 	sorted_counter = sorted(counter.items(), key=lambda x: x[0])
# 	start = 0
# 	end = len(name) - 1
# 	for key, value in sorted_counter:
# 		while value != 0:
# 			if value == 1:
# 				name[len(name) // 2] = key
# 				value -= 1
# 			else:
# 				name[start] = key
# 				name[end] = key
# 				start += 1
# 				end -= 1
# 				value -= 2
# 	answer = ''.join(name)
# 	print(answer)

def make_palindrome(name):
    # 각 문자 등장 횟수 카운트
    char_count = {}
    for char in name:
        if char in char_count:
            char_count[char] += 1
        else:
            char_count[char] = 1
    
    # 홀수 개수 문자 확인
    odd_count = 0
    odd_char = ''
    for char, count in char_count.items():
        if count % 2 != 0:
            odd_count += 1
            odd_char = char
    
    # 홀수 개수 문자가 2개 이상이면 불가능
    if odd_count > 1:
        return "I'm Sorry Hansoo"
    
    # 팰린드롬 구성
    front = []
    for char in sorted(char_count.keys()):
        front.extend([char] * (char_count[char] // 2))
    
    result = ''.join(front)
    if odd_char:  # 홀수 개수 문자가 있으면 중앙에 배치
        result += odd_char
    result += ''.join(reversed(front))
    
    return result

# 입력 처리
name = input().strip()
print(make_palindrome(name))
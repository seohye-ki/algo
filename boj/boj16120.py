import sys
input = sys.stdin.readline

s = input().strip()
stack = []

for c in s:
    stack.append(c)
    while len(stack) >= 4 and stack[-1] == 'P' and stack[-2] == 'A' and stack[-3] == 'P' and stack[-4] == 'P':
        stack.pop()
        stack.pop()
        stack.pop()

if stack == ['P']:
    print("PPAP")
else:
    print("NP")
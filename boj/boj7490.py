import sys
sys.setrecursionlimit(100000)
T = int(input())

def recursion(depth, expression):
	if depth == N:
		tmp = expression.replace(' ', '')
		if eval(tmp) == 0:
			results.append(expression)
		return
	
	next_num = str(depth + 1)

	recursion(depth + 1, expression + ' ' + next_num)
	recursion(depth + 1, expression + '+' + next_num)
	recursion(depth + 1, expression + '-' + next_num)


for _ in range(T):
    N = int(input())
    
    results = []

    recursion(1, '1')
    results.sort()
    
    for result in results:
        print(result)
    
    print() 
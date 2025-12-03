import sys
sys.setrecursionlimit(100000)
sudoku = []
for _ in range(9):
	oneline = input()
	sudoku.append([int(x) for x in oneline])

def is_valid(r, c, num):
	if num in sudoku[r]: # 행
		return False
	for i in range(9): # 열
		if num == sudoku[i][c]:
			return False
	# 3*3
	box_r = (r // 3) * 3
	box_c = (c // 3) * 3
	for i in range(box_r, box_r+3):
		for j in range(box_c, box_c+3):
			if sudoku[i][j] == num:
				return False
	return True

def dfs(r, c):
	if c == 9: return dfs(r + 1, 0)
	if r == 9: return True

	if sudoku[r][c] != 0:
		return dfs(r, c + 1)
	
	for num in range(1, 10):
		if is_valid(r, c, num):
			sudoku[r][c] = num
			if dfs(r, c + 1):
				return True
			sudoku[r][c] = 0

	return False

dfs(0, 0)
for row in sudoku:
	print(''.join(map(str, row)))
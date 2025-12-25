import sys
sys.setrecursionlimit(1000000)

N = int(input())
inorder = list(map(int, input().split())) # 좌-루트-우
postorder = list(map(int, input().split())) # 좌-우-루트
inorder_dict = {}
for i in range(N):
	inorder_dict[inorder[i]] = i
preorder = [] # 루트-좌-우

def recursion(in_start, in_end, post_start, post_end):
	if in_start > in_end:
		return
	
	root = postorder[post_end]
	preorder.append(root)

	root_idx = inorder_dict[root]
	left = root_idx - in_start

	recursion(in_start, root_idx-1, post_start, post_start+left-1) # 좌
	recursion(root_idx+1, in_end, post_start+left, post_end-1) # 우

recursion(0, N-1, 0, N-1)
print(*preorder)
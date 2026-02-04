from collections import deque

n, k = map(int, input().split())

def bfs(n, k):
    if n == k:
        return 0

    visited = [-1] * 100001
    visited[n] = 0
    
    que = deque([n])
    while que:
        curr = que.popleft()

        for next_pos in [curr - 1, curr + 1, curr * 2]:
            if 0 <= next_pos < 100001 and visited[next_pos] == -1:
                visited[next_pos] = visited[curr] + 1
                que.append(next_pos)

                if next_pos == k:
                    return visited[next_pos]
    
    return visited[k]

print(bfs(n, k))
from collections import deque

n = int(input())
a, b = map(int, input().split())
m = int(input())

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

visited = [-1] * (n + 1)
visited[a] = 0
queue = deque([a])

while queue:
    node = queue.popleft()
    for dist in graph[node]:
        if visited[dist] == -1:
            visited[dist] = visited[node] + 1
            queue.append(dist)

print(visited[b])
import heapq

n = int(input())
meetings = []
for _ in range(n):
    start, end = map(int, input().split())
    meetings.append((start, end))

meetings.sort()
heap = []

heapq.heappush(heap, meetings[0][1])

for i in range(1, n):
    start, end = meetings[i]
    if heap[0] <= start:
        heapq.heappop(heap)
    heapq.heappush(heap, end)

print(len(heap))
# import heapq
# import sys
# input = sys.stdin.readline

# N = int(input())
# lecture = []
# for _ in range(N):
#     P, Q = map(int, input().split())
#     lecture.append((Q, P))
# lecture.sort()

# schedule = []
# for deadline, price in lecture:
#     heapq.heappush(schedule, price)
#     if deadline < len(schedule):
#         heapq.heappop(schedule)

# print(sum(schedule))

import heapq
import sys
input = sys.stdin.readline

N = int(input())
lecture = []

for _ in range(N):
    p, d = map(int, input().split())
    # 마감기한이 빠른 순, 마감기한 같으면 가격 높은 순
    heapq.heappush(lecture, (d, -p))

schedule = []  # 강의료 기준 최소힙

while lecture:
    d, neg_p = heapq.heappop(lecture)
    p = -neg_p

    # 아직 해당 마감일까지 가능한 일정 수보다 적게 잡혀 있으면 추가
    if len(schedule) < d:
        heapq.heappush(schedule, p)
    else:
        # 이미 꽉 찼다면 가장 적은 강의료보다 크면 교체
        if schedule[0] < p:
            heapq.heappop(schedule)
            heapq.heappush(schedule, p)

print(sum(schedule))

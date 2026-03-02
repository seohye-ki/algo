import sys

input_data = sys.stdin.read().split()
idx = 0

N, M = int(input_data[idx]), int(input_data[idx+1])
idx += 2

num_weeks = M // 7

records = {}

for _ in range(N):
    name    = input_data[idx]
    day     = int(input_data[idx+1])
    start   = input_data[idx+2]
    end     = input_data[idx+3]
    idx += 4

    week = (day - 1) // 7

    sh, sm = map(int, start.split(':'))
    eh, em = map(int, end.split(':'))
    duration = (eh * 60 + em) - (sh * 60 + sm)

    if name not in records:
        records[name] = {}
    if week not in records[name]:
        records[name][week] = {"count": 0, "minutes": 0}

    records[name][week]["count"]   += 1
    records[name][week]["minutes"] += duration

results = []
for name, weekly in records.items():
    is_vtuber = all(
        weekly.get(w, {}).get("count",   0) >= 5 and
        weekly.get(w, {}).get("minutes", 0) >= 3600
        for w in range(num_weeks)
    )
    if is_vtuber:
        results.append(name)

results.sort()

if results:
    print('\n'.join(results))
else:
    print(-1)
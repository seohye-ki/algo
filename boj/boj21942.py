import sys
input = sys.stdin.readline
from datetime import datetime, timedelta

n, l, f = input().split()
n = int(n)
f = int(f)

parts = l.split('/')
day = int(parts[0])
time_parts = parts[1].split(':')
hour = int(time_parts[0])
minute = int(time_parts[1])
rental_period = timedelta(days=day, hours=hour, minutes = minute)

rentals = {}
fines = {}
for _ in range(n):
	line = input().split()
	date = ' '.join(line[:2])
	thing = line[2]
	name = line[3]

	time = datetime.strptime(date, "%Y-%m-%d %H:%M")

	if (name, thing) in rentals:
		start = rentals[(name, thing)]
		available = start + rental_period

		if time > available:
			fine = int((time - available).total_seconds() / 60) * f
			fines[name] = fines.get(name, 0) + fine
		
		del rentals[(name, thing)]
	else:
		rentals[(name, thing)] = time

if fines:
	users = sorted(fines.keys())
	for user in users:
		print(f"{user} {fines[user]}")
else:
	print(-1)

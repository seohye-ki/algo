n = int(input())
used = set()
answer = []

for _ in range(n):
    string = input()
    words = string.split()
    found = False
    result = []

    for i, word in enumerate(words):
        if not found and word[0].upper() not in used:
            used.add(word[0].upper())
            result.append('[' + word[0] + ']' + word[1:])
            found = True
        else:
            result.append(word)

    if not found:
        result = []
        for i, word in enumerate(words):
            if found:
                result.append(word)
                continue
            
            tmp = ""
            for j, c in enumerate(word):
                if not found and c.upper() not in used:
                    used.add(c.upper())
                    tmp += '[' + c + ']' + word[j+1:]
                    found = True
                    break
                else:
                    tmp += c
            result.append(tmp)
    
    answer.append(' '.join(result))

for s in answer:
    print(s)
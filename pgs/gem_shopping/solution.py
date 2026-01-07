def solution(gems):
    gems_len = len(gems)
    gems_type = len(set(gems))
    answer = [1, gems_len]
    
    freq = {}    
    first = 0
    for last in range(gems_len):
        freq[gems[last]] = freq.get(gems[last], 0) + 1
        while len(freq) == gems_type:
            if last - first < answer[1] - answer[0]:
                answer = [first + 1, last + 1]
            
            freq[gems[first]] -= 1
            if freq[gems[first]] == 0:
                del freq[gems[first]]
            first += 1
    return answer
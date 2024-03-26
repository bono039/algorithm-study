from itertools import product

def solution(info, query):
    answer = []
    info_dict = {}
    
    for i in info:
        i_list = i.split()
        conditions = i_list[:-1]
        score = int(i_list[-1])
        
        for condition_combination in product([0, 1], repeat=4):
            temp_key = tuple([c if flag else '-' for c, flag in zip(conditions, condition_combination)])
            if temp_key not in info_dict:
                info_dict[temp_key] = [score]
            else:
                info_dict[temp_key].append(score)

    for key in info_dict:
        info_dict[key].sort()
    
    for q in query:
        q_list = q.replace("and", "").split()
        conditions = tuple(q_list[:-1])
        score = int(q_list[-1])
        
        if conditions in info_dict:
            scores = info_dict[conditions]
            left, right = 0, len(scores)
            
            while left < right:
                mid = (left + right) // 2
                if scores[mid] >= score:
                    right = mid
                else:
                    left = mid + 1
            
            answer.append(len(scores) - left)
        else:
            answer.append(0)
    
    return answer
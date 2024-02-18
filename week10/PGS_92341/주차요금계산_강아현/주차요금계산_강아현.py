import math

def solution(fees, records):
    answer = []
    entry_exit_time = {} # 입/출차 내역 시간 계산
    in_out = [] # 출차된 내역이 없는 차를 확인하기 위한 리스트
    parking_time = {} # 누적 주차 시간 계산

    for record in records:
        time, car, in_or_out = map(str, record.split())
        timestamp = int(time[:2]) * 60 + int(time[3:])
        if in_or_out == "IN": # 입차
            in_out.append(car)
            entry_exit_time[car] = timestamp
        else: # 출차
            in_out.remove(car)
            entry_exit_time[car] = timestamp - entry_exit_time[car]
            parking_time[car] = parking_time.get(car,0) + entry_exit_time[car]
    if in_out: # 출차 기록이 없는 차량
        for car in in_out:
            end_time = 23 * 60 + 59
            entry_exit_time[car] = end_time - entry_exit_time[car]
            parking_time[car] = parking_time.get(car,0) + entry_exit_time[car]

    car_total_time = sorted(parking_time.items(), key=lambda x: x[0])
    # fees: 기본 시간[0], 기본 요금[1], 단위 시간[2], 단위 요금[3]
    for total_time in car_total_time:
        if total_time[1] <= fees[0]:
            answer.append(fees[1])
        else:
            additional_time = total_time[1] - fees[0]
            fee = fees[1] + math.ceil(additional_time / fees[2]) * fees[3]
            answer.append(fee)
    return answer
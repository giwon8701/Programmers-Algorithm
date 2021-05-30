# -*- coding:utf-8 -*-
def solution(numbers, target):
    answer = 0
    sub = [0]

    for num in numbers:
        imsi = []
        for i in sub:
            imsi.append(i + num)
            imsi.append(i - num)
        sub = imsi

    return sub.count(target)
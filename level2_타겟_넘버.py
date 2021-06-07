def solution(numbers, target):
    sub = [0]

    for num in numbers:
        imsi = []
        for i in sub:
            imsi.append(i + num)
            imsi.append(i - num)
        sub = imsi

    return sub.count(target)


print(solution([1, 1, 1, 1, 1], 3))

brown1 = [10, 8, 24]
yellow1 = [2, 1, 24]


def solution(brown, yellow):    # 가로x세로 = 넓이(=면적)(=brown+yellow)
    answer = []

    # 가로 세로는
    for i in range(int(yellow**(1/2)), 0, -1):    # 어차피 yellow는
        width = yellow//i + 2   # yellow의 가로 길이
        height = i + 2          # yellow의 세로 길이
        if width >= height and brown == height*2 + (width-2) * 2:
            answer = [width, height]
            break

    return answer


for b, y in zip(brown1, yellow1):
    solution(b, y)

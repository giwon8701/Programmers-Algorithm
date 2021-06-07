info1 = ["java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150",
         "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"]
query1 = ["java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
          "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100",
          "- and - and - and - 150"]


def solution(info, query):
    answer = []
    info_arr, query_arr = [], []

    for info_idx in info:
        info_arr.append(info_idx.split(" "))
    for query_idx in query:
        query_arr.append(query_idx.replace(" and ", " ").split(" "))

    for query in query_arr:
        cnt = 0
        for info in info_arr:   # query하나당 info를 전부 검사함
            if int(query[4]) <= int(info[4]):   # query보다 점수가 클때만 다른 조건도 검사함
                res = True
                for idx in range(4):
                    if query[idx] == "-":   # -일때는 검사 스킵
                        continue
                    elif query[idx] != info[idx]:   # 조건과 다르면 res=False 및 검사 종료
                        res = False
                        break
                if res:         # res가 True일 때, cnt 증가
                    cnt += 1
        answer.append(cnt)      # 해당 query의 cnt를 answer에 추가

    return answer


solution(info1, query1)

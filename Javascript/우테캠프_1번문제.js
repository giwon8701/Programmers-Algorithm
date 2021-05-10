function solution(weights, head2head) {
    // 승률 담는 배열
    let win_rate = [];
    // 총 인원수
    const max = weights.length;

    for (let i=0; i<max; i++) {
        win_rate[i] = [0,0,0];    // [총경기횟수, 이긴횟수, 자기보다 무거운복서 이긴횟수]

        for (let j=0; j<max; j++) {
                if (head2head[i][j] !== 'N') win_rate[i][0]++; // 경기횟수++
                if (head2head[i][j] === 'W') {
                    if (weights[i] < weights[j]) win_rate[i][2]++;   // 무거운복서 이긴횟수++

                    win_rate[i][1]++;   // 이긴횟수++
                }
        }
        // [선수번호, 승률, 무거운복서이긴횟수, 몸무게]
        win_rate[i]['num'] = i+1;
        win_rate[i]['rate'] = (win_rate[i][1]/win_rate[i][0]*100).toFixed(2);
        win_rate[i]['win_heavier'] = win_rate[i][2];
        win_rate[i]['weight'] = weights[i];
        win_rate[i].splice(0, 3);
    }


    win_rate.sort((a, b) => (a['rate'] !== b['rate']) ? b['rate']-a['rate'] : (a['win_heavier'] !== b['win_heavier']) ? b['win_heavier'] - a['win_heavier'] : (a['weight'] !== b['weight']) ? b['num'] - a['num'] : a['weight'] - b['weight']);
    // win_rate.sort((a, b) => (a['rate'] !== b['rate']) ? b['rate']-a['rate'] : 
    //                         (a['win_heavier'] !== b['win_heavier']) ? b['win_heavier'] - a['win_heavier'] : 
    //                         (a['weight'] !== b['weight']) ? b['num'] - a['num'] : a['weight'] - b['weight']);

    // 삼항 안쓴 코드
    // if (a['rate'] !== b['rate']) {
    //     return b['rate']-a['rate']
    // }
    // else {
    //     if (a['win_heavier'] !== b['win_heavier']) {
    //         return b['win_heavier'] - a['win_heavier'];
    //     }
    //     else {
    //         return (a['weight'] !== b['weight']) ? b['num'] - a['num'] : a['weight'] - b['weight'];
    //     }
    // }
    
    
    return win_rate.map(win_rate => win_rate['num']);
}

const weights = [
    [50, 82, 75, 120],
    [145, 92, 86],
    [60, 70, 60]
]

const head2head = [
    ['NLWL', 'WNLL', 'LWNW', 'WWLN'],
    ['NLW', 'WNL', 'LWN'],
    ['NNN', 'NNN', 'NNN']
]

for (let i=0; i<weights.length; i++) {
    console.log(solution(weights[i], head2head[i]));
}
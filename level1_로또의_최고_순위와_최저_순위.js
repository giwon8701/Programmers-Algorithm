function solution(lottos, win_nums) {
    var answer = [7, 7];
    const cnt = lottos.filter(num => (num === 0)).length;   // 0의 개수
    
    win_nums.map(num => (lottos.includes(num)) ? (answer[0] -= 1, answer[1] -= 1) : '');
    
    answer[0] -= cnt;
    answer[1] = (answer[1] === 7) ? 6 : answer[1];
    
    return answer;
}
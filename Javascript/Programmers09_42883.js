
function solution(number, k) {
    let answer = '';
    let arr = [];
    let temp = [0, 0];

    // 가장 큰 자릿수부터 찾는다.(k+1 갯수만큼)
    for (let i=0; i<=k; i++) {
        if (temp < number[i] || number[i] === 9) {
            temp = [i, number[i]];
        }
    }
    // 찾은 자릿수 앞부분은 다 지워줌
    for (let i=0; i<temp[0]; i++) {
        number.shift();
    }




    return answer;
}

let number = [1924, 1231234, 4177252841];
let k = [2, 3, 4];

for (let i=0; i<number.length; i++) {
    console.log(solution(number[i], k[i]));
}
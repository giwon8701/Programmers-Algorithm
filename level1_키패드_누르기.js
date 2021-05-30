function solution(numbers, hand) {
    let answer = '';
    const left = [1, 4, 7, '*'];
    const right = [3, 6, 9, '#'];
    const center = [2, 5, 8, 0];
    let leftHand = [3, 0];
    let rightHand = [3, 2];

    numbers.map(num => {
        if (num === 1 || num === 4 || num === 7 || num === "*") {
            leftHand = [left.indexOf(num), 0];
            answer += "L";
        } else if (num === 3 || num === 6 || num === 9 || num === "#") { 
            rightHand = [right.indexOf(num), 2];
            answer += "R";
        } else {
            const centerNum = [center.indexOf(num), 1];
            if (distance_num(leftHand, centerNum) < distance_num(rightHand, centerNum)) {
                leftHand = centerNum;
                answer += "L";
            } else if (distance_num(leftHand, centerNum) > distance_num(rightHand, centerNum)) {
                rightHand = centerNum;
                answer += "R";
            } else {
                if (hand === 'left') {
                    leftHand = centerNum;
                    answer += "L";
                } else {
                    rightHand = centerNum;
                    answer += "R";
                }
            }
        }
    });



    
    return answer;
}

function distance_num(num1, num2) {
    return Math.pow(Math.abs(num1[0] - num2[0]), 2) + Math.pow(Math.abs(num1[1] - num2[1]), 2)
}


const numbers = [
    [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5],
    [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2],
    [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
];

const hand = [
    "right",
    "left",
    "right"
];

// for(let i=0; i<numbers.length; i++) {
    console.log(solution(numbers[1], hand[1]));
// }

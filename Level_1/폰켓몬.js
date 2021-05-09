/*
https://programmers.co.kr/learn/courses/30/lessons/1845
*/

function solution(nums) {
    const max = nums.length/2;          // N/2
    const setNum = new Set(nums).size;  // 폰켓몬 종류수의 최댓값

    return (max > setNum) ? setNum : max;
}

const nums = [
    [3, 1, 2, 3],
    [3, 3, 3, 2, 2, 4],
    [3, 3, 3, 2, 2, 2]
];

nums.forEach(nums => console.log("nums = ["+nums+"]\nresult = "+solution(nums)+"\n"));

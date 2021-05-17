/*
https://programmers.co.kr/learn/courses/30/lessons/42576
*/

// function solution(participant, completion) {

//     participant.sort();
//     completion.sort();
//     let i = 0;

//     while (participant[i] === completion[i]) {
//         i++;
//     }

//     const answer = participant[i];
//     return answer;
// }

const solution = (participant,completion) => { 
    completion.forEach(name => completion[name] = (completion[name]|0)+1);
    console.log(completion);
    console.log(`${completion[0]} : ${completion[completion[0]]}`);
    return participant.find(name => !completion[name]--);
    // find() : 값이 true면 값 반환
    // 1. completion[name]이 0보다 크면 true지만, !때문에 false를 출력
    // 2. mislav를 한번 find해서 completion['mislav'] = 0 이 되어버림
    // 3. mislav를 한번 더 find했는데 completion[name]은 0이므로 false, !때문에 true로 출력
    // 4. 뒤에 --은 리턴되고 실행되는거니 무시해도됨
    // 5. return값으로 'mislav' 리턴
};

const participant = [
    ["leo", "kiki", "eden"],
    ["marina", "josipa", "nikola", "vinko", "filipa"],
    ["mislav", "stanko", "mislav", "ana"]
];

const completion = [
    ["eden", "kiki"],
    ["josipa", "filipa", "marina", "nikola"],
    ["stanko", "ana", "mislav"]
];

//for(let i=0; i<participant.length; i++) {
    console.log("answer = " + solution(participant[2], completion[2]));
//}

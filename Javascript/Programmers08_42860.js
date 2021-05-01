
var cursor = 0;

function solution(name) {
    let answer = 0;
    let res = [];
    let same = [];
    
    for (let i=0; i<name.length; i++) {
        res.push("A");
        same[i] = (res[i] === name[i]);
    }
    
    let i = 0;

    for (let i=0; i < name.length; i++) {
        if (!same[i]) {
            nextChar(res, i);
            answer++;
            if (res[i] === name[i]) {
                same[i] = true;
            } else {
                i--;
            }
        }
    }


    console.log(res.join(""));

    return answer;
}

function nextChar(res, i) {
    if (cursor === res.length-1) cursor = 0;
    else cursor++;
    res[i] = (res[i] === 'Z') ? 'A' : String.fromCharCode(res[i].charCodeAt()+1);
}
function prevChar(res, i) {
    if (cursor === 0) cursor = res.length-1;
    else cursor--;
    res[i] = (res[i] === 'A') ? 'Z' : String.fromCharCode(res[i].charCodeAt()-1);
}


const name = ["JEROEN", "JAN"];
let i = 0;

console.log(solution(name[i]));
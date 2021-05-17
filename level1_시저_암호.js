/*
https://programmers.co.kr/learn/courses/30/lessons/12926
*/

function solution(s, n) {
    // 문자열같이 배열이 아닌것들을 map에서 쓸때 .call()을 씀
    const answer = Array.prototype.map.call(s,
        c => {
            let a = '';
            // c가 알파벳일 때
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                // charCodeAt(n) : 문자열의 n번째 자리를 아스키코드로 변환
                a = c.charCodeAt(0)+n;
                
                // 알파벳을 밀었을 때 z보다 크다면, 밀린만큼 'a'에 더해줌
                if (String.fromCharCode(a) > 'z') {
                    a = 'a'.charCodeAt(0) + (a -'z'.charCodeAt(0) - 1);
                } else if (String.fromCharCode(a) > 'Z' && c <= 'Z') {
                    a = 'A'.charCodeAt(0) + (a -'Z'.charCodeAt(0) - 1);
                }
                a = String.fromCharCode(a);
            } else {
                a = c;
            }
            return a;
        });

    return answer.join("");
}

console.log(solution("ABZ", 1));
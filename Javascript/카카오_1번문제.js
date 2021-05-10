function solution(s) {
    let answer = 0;

    const num_eng = {
        "zero" : 0,
        "one" : 1,
        "two" : 2,
        "three" : 3,
        "four" : 4,
        "five" : 5,
        "six" : 6,
        "seven" : 7,
        "eight" : 8,
        "nine" : 9
    }


    for (key in num_eng) {
        console.log(key + " : " + num_eng[key])
        s.replace(key, `${num_eng[key]}`)
    }
    console.log(s)

    // Object.keys(num_eng).forEach(v => {
    //     console.log(num_eng[v])
    //     //s.replace(/`${num_eng}`/g, num_eng)
    // })
    

    return answer;
}

let s = ["one4seveneight", "23four5six7", "2three45sixseven", "123"]


s.forEach(s => solution(s));
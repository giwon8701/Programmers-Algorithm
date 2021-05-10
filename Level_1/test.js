const completion = ["stanko", "ana", "mislav"];

completion.forEach(name => completion[name] = (completion[name]|0)+1);
console.log(completion);
for (let i=0; i<completion.length; i++) {
    console.log(`${completion[i]} : ${completion[completion[i]]}`);
}
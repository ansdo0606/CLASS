//객체선언

const btn01 = document.querySelector('#btn01');
btn01.addEventListener("click",()=>{
    //const x = new Object(); //객체만들기
    const x = {
        age : 20,
        height : 183.7,
        weight : 43.2
    };
    console.log(x);

    console.log(x.age);
    console.log(x.height);
    console.log(x.weight);

    x.nick = "OrcaMoon";
    x.colors = ["소라색","연분홍","채도가 낮은 색"];

    console.log(x.colors[0]);
    x.hello = function(){
        console.log("hello @@@");
    };

    x.hello();

    x.age = 21;
    console.log(x['age']);

})

//객체 반복문 테스트
const btn02 = document.querySelector("#btn02");
btn02.addEventListener("click",()=>{
    const computer = {
        cpu : "i5",
        ram : 16,
        os : "window"
    };

    // console.log(computer.cpu);
    // console.log(computer.ram);
    // console.log(computer.os);

    for (let temp in computer) {
        //console.log(temp+" / "+computer[temp]);
        console.log(`${temp} / ${computer[temp]}`);
        //중간중간에 변수를 집어넣을때 유용함

    }
});

//객체 속성 추가 및 제거
const btn03 = document.querySelector("#btn03");
btn03.addEventListener("click",()=>{
    const obj = {};

    //속성 추가
    obj.name = "정문애";
    obj.age = 30;
    obj.hello = ()=>{alert("안녕")};

    console.log(obj);
    obj.hello();

    //속성 제거

    delete(obj.hello);

    obj.hello();
});

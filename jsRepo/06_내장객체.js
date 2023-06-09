// Object
const btn01 = document.querySelector("#btn01");
btn01.addEventListener("click",()=>{
    const x = {
        name : "정문애",
        age : 30
    };

    
    console.log(x instanceof Object);

    //객체가 속성을 가지고 있는지 체크
    console.log(x.hasOwnProperty("name"));

});

//Number
const btn02 = document.querySelector("#btn02");
btn02.addEventListener("click",()=>{

    let num = 364982492;
    let num2 = Number(3.14);
    let num3 = new Number(3.14);

    console.log(num instanceof Number); 
    console.log(num2 instanceof Number); 
    console.log(num3 instanceof Number); 

    console.log(num.toFixed(4)); //소수점 아래 자리 고정시키는 메소드
    console.log(num2.toPrecision(3)); //글자수 제한
    console.log(num.toExponential()); //숫자를 지수 표현식으로 나타냄



});

//String
const btn03 = document.querySelector("#btn03");
btn03.addEventListener("click",()=>{

    let s = "helloworld";
    let s2 = new String("hellworld");
    
    console.log(s instanceof String);
    console.log(s2 instanceof String);

    console.log(s.bold());
    console.log(s.italics());
    console.log(s.link("http://www.naver.com"));
});

//Date
const btn04 = document.querySelector("#btn04");
btn04.addEventListener("click",()=>{

    let d1 = new Date();
    let d2 = new Date('2002/12/31 14:03:15');
    let d3 = new Date(2002,12,31,14,3,15);

    console.log(d1);
    console.log(d2);
    console.log(d3);

    console.log(d1.getFullYear()); 
    console.log(d1.getMonth());
    console.log(d1.getDate());
    console.log(d1.getDay());
    console.log(d1.getHours());
    console.log(d1.getMinutes());
    console.log(d1.getSeconds());
    console.log(d1.getMilliseconds());
    

});
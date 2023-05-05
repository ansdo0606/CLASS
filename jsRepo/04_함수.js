
// 1) 선언적 함수
const btn01 = document.querySelector("#btn01");
btn01.addEventListener("click",f01);

function f01() {
    alert('선언적 함수');
}

// 2) 익명함수
const btn02 = document.querySelector("#btn02");
btn02.addEventListener("click",function () {
    alert("함수 실행");
});

// 3) 자동실행 함수
// const btn03 = document.querySelector("#btn03");
// btn03.addEventListener("click",f03);

// (function f03 (x) {
//     alert("전달받은 데이터 : " + x);
// })(123);

// (function f03(x) {
//     alert("받은 데이터 : " + x);
// }(777)
// );

// 4) 화살표 함수
const btn04 = document.querySelector("#btn04");
btn04.addEventListener("click", () => {
    alert(x);
});

//==================================================

// 1) 매개변수
const btn05 = document.querySelector("#btn05");
btn05.addEventListener("click",()=>{
    f05();
});

function f05(x=0,y=0) {
    alert(x+y);
}

// 2) arguments
const btn06 = document.querySelector("#btn06");
btn06.addEventListener("click", ()=>{
    f06(1,2,3,4,5);
});
function f06() {
    let result = 0;
    for(let x of arguments){
        result += x;
    }
    alert (result);
}

//=================================================
//내장함수

// 1) eval
const btn07 = document.querySelector("#btn07");
btn07.addEventListener("click",()=>{
    let str = prompt("실행할 코드를 입력하시오.");
    eval(str);
    
})

//2) isFinite, isNaN
const btn08 = document.querySelector("#btn08");
btn08.addEventListener("click",()=>{
   let result1 = 3/1;
   console.log(result1);
   console.log(isFinite(result1));

   let result2 = 10 / "abc";
   console.log(result2);
   console.log(isNaN(result2));
});





//변수와 자료형 
//전역 변수 선언
x1 = "함수 밖에 만든 변수(전역변수)";
var x2 = "함수 밖에 만든 var변수(전역변수)";
let x3 = "함수 밖에 만든 let변수(전역변수)";
const x4 = "함수 밖에 만든 const변수(전역변수)";
//함수 외부에 선언하면 var를 붙여도 전역변수
//console.log(x);

window.onload = function f01(){
    var v1 = "함수 내 var 변수"
   // console.log(window.v1);
    //console.log(this.v1); ->추천 안함 비추..
    var x99;
    console.log(x99);

    var b= true;
    var n = 123;
    var o = new Object();
    var f = function tempFunc(){}
    //typeof
    console.log(typeof x1);
    console.log(typeof x99);
    console.log(typeof b);
    console.log(typeof n);
    console.log(typeof o);
    console.log(typeof f);

    console.log("==================================");
    //var, let, const
    //var : 재선언(declare) 가능, 할당 자유롭게 가능
    //let : 1번 선언 가능, 할당 자유롭게 가능(java변수 같음)
    //const : 1번 선언 가능, 1번 할당 가능(final같음)

    //============================================================================
    //2) 유효범위 (스코프)
    //함구 안에서 var호 선언된 변수 : 함수 스코프
    //console.log(temp); //var로 선언된 경우에만 에러가 안난다.
    //var는 특수한 경우 (hoisting)으로 위로 올라간다.
    if (true) {
        var temp = 123;
        console.log(temp);
    }
    console.log(temp); //let,const면 {}안에서 생성되었기 때문에 밖에선 에러남

    console.log('================================================================');
    console.log('==========================강제형변환=============================');

    parseInt('3');
    parseFloat('3.14');
    Number('123');
    String(777);

    const arr =[10,20,30];
    // for (let i = 0; i < array.length; ++i) {
    //     console.log(arr[i]);
    // }
    for(let i in arr){//arr의 인덱스가 나온다
        console.log(i);
    }
    for(let x of arr){//arr의 요소가 나온다
        console.log(x);
    }

}//window.onload function





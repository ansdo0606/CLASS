const openBtn = document.querySelector("#openBtn");
openBtn.addEventListener("click",()=>{

    //window.open(); //새로운 윈도우를 오픈해준다.
    //window.open("http://www.naver.com");
    //누를때마다 해당 창이 뜬다. 
    window.open("http://www.naver.com","abc");
    //이름을 지정하면 누를때마다 해당 창으로 이동한다.


});

const timeOutTestBtn = document.querySelector("#timeOutTestBtn");
const intervalTestBtn = document.querySelector("#intervalTestBtn");
timeOutTestBtn.addEventListener("click",()=>{

    const newWindow = open("http://www.naver.com");
    
    setTimeout(()=>{
        newWindow.close();
    },3000);

    // setTimeout(()=>{
    //     alert("3초 지남");
    // },3000); 
//(함수, 시간) = "시간" 뒤에 "함수"(나중에 실행하는 함수 :callback)가 발동하게 한다.


});
intervalTestBtn.addEventListener("click",()=>{
    setInterval(()=>{
        console.log("3초");
    },3000);//3초마다 반응
});

//location

const btn01 = document.querySelector("#btn01");
btn01.addEventListener("click",()=>{
    console.log(window.location);

    const x = setTimeout(()=>{
        //location.reload(); //새로고침
        location.href = "http://www.naver.com";//동적으로 다른 사이트로 넘어가는것도 가능
    },3000);

    //clearTimeout(x); //Timeout 삭제
});

//navigator
const btn03 = document.querySelector("#btn03");
btn03.addEventListener("click",()=>{
    console.log(navigator);
});

//screen
const btn04 = document.querySelector("#btn04");
btn04.addEventListener("click",()=>{
    console.log(screen);
});
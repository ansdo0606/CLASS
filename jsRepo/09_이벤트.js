const btn01 = document.querySelector("#btn01");
btn01.onclick = ()=>{
    alert("고전 이벤트 실행");
};
//btn01.addEventListener("click",()=>{}); 표준 이벤트 모델

function f02() {
    alert("인라인 이벤트 모델 실행");
};

const btn03 = document.querySelector("#btn03");
btn03.addEventListener("click",()=>{
    alert("표준 이벤트 모델 실행");
});
btn03.addEventListener("click",()=>{
    alert("표준 이벤트 모델 실행2");
});

const btn04 = document.querySelector("#btn04");
btn04.addEventListener("click",function(x){
    console.log("클릭 이벤트 발생");
    console.log(x.target);
});

function checkMember() {
  //비번 일치하면 진행, 아니면 막음

  const pwd1= document.querySelector("input[name = memberPwd]").value;
  const pwd2= document.querySelector("input[name = memberPwd2]").value;

  if (pwd1==pwd2) {
    return true;
  }  else{
    alert("비밀번호가 일치하지 않습니다.");
    return false;
    
  }
};
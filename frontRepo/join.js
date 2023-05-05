//비번 일치 여부

window.onload = ()=>{ //defer 안쓴경우 써준다
    const pwd1 = document.querySelector("input[name=pwd1]");
    const pwd2 = document.querySelector("input[name=pwd2]");

    const form = document.querySelector("form");
    form.onsubmit = checkPwd;
    function checkPwd() {
        if(!(pwd1.value === pwd2.value)){
        //비번창 색 변경
        pwd1.style.backgroundColor = "red";
        return false;
       }
       return true;
    }

};
let isIdOk = false;
let isPwdOk = false;
       
    const memberId = document.querySelector("input[name=memberId");
    const pwd1 = document.querySelector("input[name=pwd1]");
    const pwd2 = document.querySelector("input[name=pwd2]");
    const idResult = document.querySelector("#id-result");
    const pwdResult = document.querySelector("#pwd-result");
    const btn00 = document.querySelector("#btn00");

    btn00.addEventListener("click",()=>{
        const Id = memberId.value;

        if (Id.length < 6 || Id.length > 12) {
            isIdOk = false;
            idResult.innerText = "사용이 불가능합니다.";
            idResult.classList.remove("blue-color");
            idResult.classList.add("red-color");

        }else{
            isIdOk = true;
            idResult.innerText = "사용이 가능합니다.";
            idResult.classList.remove("red-color");
            idResult.classList.add("blue-color");
        }
    });

    pwd2.addEventListener("blur",()=>{
        if (pwd1.value === pwd2.value) {
            isPwdOk = true;
            pwdResult.innerText = "일치합니다.";
            pwdResult.classList.remove("red-color");
            pwdResult.classList.add("blue-color");
            }else{
                isPwdOk = false;
                pwdResult.innerText = "불일치합니다.";
                pwdResult.classList.remove("blue-color");
                pwdResult.classList.add("red-color");
            }
        });
        function checkValid() {
            if (!isPwdOk) {
                alert("비밀번호를 확인하세요");
                return false;
            } if(!isIdOk) {
                alert("아이디를 확인하세요");
                return false;
            }
			return true;
        }
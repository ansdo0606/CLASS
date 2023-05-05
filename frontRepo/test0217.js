const id = document.querySelector("input[name=memberId]");
const area = document.querySelector("input[type=radio]:checked");
const submit = document.querySelector("input[type=submit]");

const btn1 = document.querySelector("#btn1");
btn1.addEventListener("click",()=>{
    var str = "/^[a-z0-9!@#]{6,12}$/";
    var result = str.test(id);

    if(result === true){
        id.classList.add("green-color");
        id.classList.remove("red-color")
    }else{
        id.classList.add("red-color");
        id.classList.remove("green-color")
    }
});

function checkValid() {
    submit.addEventListener("click",()=>{
        if(area.value === true){
            return true;
        }else{
            alert("지역을 선택하세요");
            return false;
        }
    });
};
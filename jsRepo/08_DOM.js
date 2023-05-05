//1.텍스트 노드가 있는 요소 생성

const btn01 = document.querySelector("#btn01");
btn01.addEventListener("click",()=>{
    //text가 있는 
    const tag = document.createElement('h1');
    const text = document.createTextNode("helloWorld");

    tag.appendChild(text); //tag 안에 text 추가 (tag의 자식레벨로 집어넣음)
    console.log(tag);
    //console.log(text);
    const body = document.querySelector("body");
    body.appendChild(tag); //바디에 태그가 나오게 하는 동작

    const t01 = document.querySelector("#target01");
    t01.appendChild(tag);

});

//2. 텍스트 노드가 없는 요소 생성
const btn02 = document.querySelector("#btn02");
btn02.addEventListener("click",()=>{
    const tag = document.createElement("img");
    tag.src = "https://img.gqkorea.co.kr/gq/2022/10/style_634e7c680d723.jpg";
    // tag.width = '300';
    // tag.height= '300';

    tag.setAttribute('width',100);
    tag.setAttribute('height',100);
    tag.setAttribute('atk',777);

    const t02 = document.querySelector("#target02");
    t02.appendChild(tag);


});

//Node 삭제
const btn03 = document.querySelector("#btn03");
btn03.addEventListener("click",()=>{
    
    const arr = document.querySelectorAll("h2");
    const t = arr[arr.length-1];
    t.remove();

});
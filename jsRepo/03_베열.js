// 1) indexOf()
function f01() {
    let arr = ['사과','오렌지','딸기','포도','바나나'];
    let result = arr.indexOf('딸기');
    console.log(result);
}

// 2) concat()
function f02() {
    let arr1 = ['10','20','30'];
    let arr2 = ['일','이','삼'];
    let result = arr1.concat(arr2);
    console.log(result);
}

// 3) join()
function f03() {
    let arr = ['핸드폰','카메라','가방','키보드'];
    let result = arr.join();
    console.log(result);
}

// 4) reverse()
function f04() {
    let arr = [3,5,999,123,54321];
    let result = arr.reverse();
    console.log(arr); //원본 배열에도 영향을 끼친다.
    console.log(result);
}

// 5) sort()
function f05() {
    let arr = [10,90,50,7777,3];
    let result = arr.sort(compareFunc); //비교함수를 사용해서 문자열이 아닌
    console.log(result);
}
function compareFunc(x,y) {
    return x-y;
}

// 6) push(), pop()
function f06() {
    let arr = ['아이유','뉴진스','NCT127','aespa'];
    let result = arr.push('방탄소년단');
    console.log(result);
    console.log(arr);
    let result2 = arr.push('투바투');
    console.log(result2);
    console.log(arr);
    let result3 = arr.pop();
    console.log(result3);
    console.log(arr);
    let result4 = arr.pop();
    console.log(result4);
    console.log(arr);
}

// 7) shift(), unshift()
function f07() {
    let arr = ['아이유','뉴진스','NCT127','aespa'];
    let result = arr.shift();
    console.log(result);
    console.log(arr);
    let result2 = arr.shift();
    console.log(result2);
    console.log(arr);
    let result3 = arr.unshift('아이브');
    console.log(result3);
    console.log(arr);
}

// 8) slice(), splice()
function f08() {
    let arr = ['java','oracle','html','css','js'];
    let result = arr.slice(1,4);
    console.log(result);
    console.log(arr);
    let result2 = arr.splice(1,2,'mybatis','spring');
    console.log(result2);
    console.log(arr);
}
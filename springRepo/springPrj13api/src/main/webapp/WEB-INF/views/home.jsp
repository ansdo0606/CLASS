<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
	
	<h1>홈페이지</h1>
	
	<button onclick="loadWeather();">기상특보 확인</button>
	
	<div id="weather-area">
        
	</div>
    <table border="1">
        <thead>
            <tr>
                <th>tmSeq</th>
                <th>title</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td></td>
                <td></td>
            </tr>
        </tbody>
    </table>
</body>
</html>

<script>
	function loadWeather() {
        $.ajax({
            url : "/app/test2",
            type : "GET",
            //data : ,
            //dataType : "JSON", //json을 사용하면 바로 한글깨짐 현상이 해결됨
            success : function(x){
                console.log(x);
                const weatherArea = document.querySelector("#weather-area");
                weatherArea.innerHTML=x;

                //테이블 내용 채우기
                const itemArr = x.response.body.items.item;
                const tbody = document.querySelector('tbody');
                let str = "";
                for (let i = 0; i < itemArr.length; i++) {
                    str += '<tr>';
                    str += '<td>';
                    str += itemArr[i].tmSeq;
                    str += '</td>';
                    str += '<td>';
                    str += itemArr[i].title;
                    str += '</td>';
                    str += '</tr>';
                }
                tbody.innerHTML = str;

            },
            error : function(e){
                console.log(e);
            }

        });

        

    }

</script>


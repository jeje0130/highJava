<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON데이터 처리하기</title>
<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
   $(function(){
      
      //문자열
      $('#strBtn').on('click', function(){
         
         $.ajax({
            "url" : "<%= request.getContextPath()%>/JSONServlet.do",
            "type" : "post",
            "data" : "choice=str",
            "success" : function(data){
               $('#result').empty();
               $('#result').append(data);
               $('#result').append("<hr color='red'>");
            },
            "error" : function(xhr){
               alert("상태 : " + xhr.status);
            },
            "dataType" : 'json'
         })
      });
      
      //배열
      $('#arrayBtn').on('click', function(){
         
         $.ajax({
            "url" : "<%= request.getContextPath()%>/JSONServlet.do",
            "type" : "post",
            "data" : "choice=array",
            "success" : function(data){
            	$('#result').empty();
            	$.each(data, function (i, v) {
					$('#result').append(i + "번째 자료 : " + v + "<br>")
				});
            	$('#result').append("<hr color='green'>");
            	
            },
            "error" : function(xhr){
               alert("상태 : " + xhr.status);
            },
            "dataType" : 'json'
            
         })
         
      });
      
    
      
      //객체
      $('#objBtn').on('click', function(){
         $.ajax({
            "url" : "<%= request.getContextPath()%>/JSONServlet.do",
            "type" : "post",
            "data" : "choice=obj",
            "success" : function(data){
            	$('#result').empty();
            	
            	$('#result').append("ID : " + data.id + "<br>");
            	$('#result').append("NAME : " + data.name + "<br>");
            	
            	$('#result').append("<hr color='blue'>");
            },
            "error" : function(xhr){
               alert("상태 : " + xhr.status);
            },
            "dataType" : 'json'
         })
      });
      
      //리스트
      $('#listBtn').on('click', function(){
         $.ajax({
            "url" : "<%= request.getContextPath()%>/JSONServlet.do",
            "type" : "post",
            "data" : "choice=list",
            "success" : function(data){
				$('#result').empty();
            	
            	$.each(data, function (i, v) {
					$("#result").append("ID : " + v.id + "<br>")
					$("#result").append("NAME : " + v.name + "<hr>")
				});
            	
            	$('#result').append("<hr color='orange'>");
            },
            "error" : function(xhr){
               alert("상태 : " + xhr.status);
            },
            "dataType" : 'json'
         })
      });
      
      //Map객체
      $('#mapBtn').on('click', function(){
         $.ajax({
            "url" : "<%= request.getContextPath()%>/JSONServlet.do",
            "type" : "post",
            "data" : "choice=map",
            "success" : function(data){
				$('#result').empty();
            	/* 
            	$('#result').append("name : " + data.name + "<br>");
            	$('#result').append("tel : " + data.tel + "<br>");
            	$('#result').append("addr : " + data.addr + "<br>");
            	 */
            	$.each(data, function (key, value) {
					$('#result').append(key + " : " + value + "<br>")
				}); 
            	
            	$('#result').append("<hr color='purple'>");
            },
            "error" : function(xhr){
               alert("상태 : " + xhr.status);
            },
            "dataType" : 'json'
         })
      });
   });
   
</script>
</head>
<body>
	<form>
		<input type="button" id="strBtn" value="문자열"> <input
			type="button" id="arrayBtn" value="배열"> <input type="button"
			id="objBtn" value="객체"> <input type="button" id="listBtn"
			value="리스트"> <input type="button" id="mapBtn" value="Map객체">
	</form>
<hr>
<div id="result"></div>

</body>
</html>
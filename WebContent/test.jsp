<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="./resource/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#id_check").click(function() { //중복체크아이디 클릭이벤트  
			$.ajax({
				url : "idcheck.jsp",//아이디중복체크할페이지 지정
				data:({userid:$("input[name=id]").val()}),
				success : function(data) {
					if (jQuery.trim(data) == 'YES') {
						$('#idmessage').html("<font color=red>사용 가능합니다.</font>");
						$('#idmessage').show();
					}
					if (jQuery.trim(data) == 'NO') {
						$('#idmessage').html("<font color=red>이미 사용중인 아이디입니다.</font>");
						$('#idmessage').show();
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<input name="id" type="text" class="userinput" size="15" maxlength="20" />
	<button type="button" id="id_check">중복체크</button>
	<div id="idmessage" style="display: none;"></div>
</body>
</html>
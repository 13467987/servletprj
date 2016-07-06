<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>JS Company Beta</title>
<script type="text/javascript" src="../../resource/js/lib/SE2.8.2.O12056/js/HuskyEZCreator.js" charset="utf-8"></script>
</head>
<body>
	<header>
	<div class="container">
		<jsp:include page="../header.jsp" flush="true"></jsp:include>
		</div>
	</header>
	<div class="container">
	<jsp:include page="../logo.jsp" flush="true"></jsp:include>
	</div>
	<div class="container">
	<div id="wrap">
		<jsp:include page="../menu.jsp" flush="true"></jsp:include>
		<div id="content">
			<form action="/board.do?action=write" method="post" enctype="multipart/form-data">
				제목:<input type="text" class="form-control" placeholder="Text input" name="title"><br> 내용:<br>
				<textarea id="ir1" cols="10" name="content" style="width: 100%" ></textarea>
				<input type="file" name="upfile" class="btn btn-default">
				<input type="button" onclick="submitContents(this);" class="btn btn-default" value="등록" />
			</form>
		</div>
	</div>
	<script type="text/javascript" charset="utf-8">
var oEditors = [];

// 추가 글꼴 목록
//var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];

nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "ir1",
	sSkinURI: "../../resource/js/lib/SE2.8.2.O12056/SmartEditor2Skin.html",	
	htParams : {
		bUseToolbar : true,				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseVerticalResizer : true,		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseModeChanger : true,			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
		//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
		fOnBeforeUnload : function(){
			//alert("완료!");
		}
	}, //boolean
	fOnAppLoad : function(){
		//예제 코드
		//oEditors.getById["content"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
	},
	fCreator: "createSEditor2"
});

function pasteHTML() {
	var sHTML = "<span style='color:#FF0000;'>이미지도 같은 방식으로 삽입합니다.<\/span>";
	oEditors.getById["ir1"].exec("PASTE_HTML", [sHTML]);
}

function showHTML() {
	var sHTML = oEditors.getById["ir1"].getIR();
	alert(sHTML);
}
	
function submitContents(elClickedObj) {
	oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
	
	// 에디터의 내용에 대한 값 검증은 이곳에서 document.getElementById("content").value를 이용해서 처리하면 됩니다.
	
	try {
		elClickedObj.form.submit();
	} catch(e) {}
}

function setDefaultFont() {
	var sDefaultFont = '궁서';
	var nFontSize = 24;
	oEditors.getById["ir1"].setDefaultFont(sDefaultFont, nFontSize);
}
</script>
</div>
</body>
   <script type="text/javascript">  
    $(document).ready(function(){
    	$("#menu li:nth-child(2)").addClass("active");
    });
    </script>
</html>
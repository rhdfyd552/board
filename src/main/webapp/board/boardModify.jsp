<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<title>Insert title here</title>

<link rel="shortcut icon" href="favicon.ico" />
 <%@ include file="/include/commonCss.jsp" %>
 <%@ include file="/include/jQuery.jsp" %>
<!-- jQuery -->
<!-- <script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery-ui.min.js"></script>-->
<link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link href="${pageContext.request.contextPath }/dashboard.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script src="${pageContext.request.contextPath}/js/jQuery.MultiFile.min.js"></script>

<script src="${pageContext.request.contextPath}/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
	

	
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "${pageContext.request.contextPath}/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});

	// 전송버튼 클릭이벤트
	$("#savebutton").click(function(){
		if(confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if(validation()) {
				$("#frm").submit();
			}
		}
	})
	

	 $('#frm input[name=file]').MultiFile({
	        max: 3, //업로드 최대 파일 갯수 (지정하지 않으면 무한대)
	        maxfile: 1024, //각 파일 최대 업로드 크기
	        maxsize: 3024,  //전체 파일 최대 업로드 크기
	        STRING: { //Multi-lingual support : 메시지 수정 가능
	            remove : "제거", //추가한 파일 제거 문구, 이미태그를 사용하면 이미지사용가능
	            duplicate : "$file 은 이미 선택된 파일입니다.", 
	            denied : "$ext 는(은) 업로드 할수 없는 파일확장자입니다.",
	            selected:'$file 을 선택했습니다.', 
	            toomuch: "업로드할 수 있는 최대크기를 초과하였습니다.($size)", 
	            toomany: "업로드할 수 있는 최대 갯수는 $max개 입니다.",
	            toobig: "$file 은 크기가 매우 큽니다. (max $size)"
	        },
	    });

	
	
});

// 필수값 Check
function validation(){
	var contents = $.trim(oEditors[0].getContents());
	if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}

	return true;
}


</script>
<style>
	form{
		margin-top: 50px;
		margin-left: 30%;
	}
	#title {
		width: 650px;
	}
</style>
</head>
<body>

    <%@ include file="/layout/header.jsp" %>
    <div class="container-fluid">
      <div class="row">
        <%@ include file="/layout/left.jsp" %>
			<div class="container-fluid">
		<div class="row">

		<form action="${pageContext.request.contextPath }/modifyBoard"  method="post" id="frm" enctype="multipart/form-data">
			<div class="form-group">
				<label class="col-sm-2 control-label">게시판 선택</label>
					<select name="notices">
						<c:forEach items="${notice}" var="notice">
							<option value="${notice.no_seq }">${notice.no_name }</option>
						</c:forEach>
					</select>
			</div>	
			<input type="hidden" name="board_seq" value="${boardVO.board_seq }">
			<div class="form-group">
				<label class="col-sm-1 control-label">제목</label>
				<input type="text" id="title" name="title" value="${boardVO.title }">
			</div>
			<div>
				<label class="col-sm-1 cotrol-label">첨부파일</label>
				<input type="file" class="multi"id="file" name="file" maxlength="5">
			</div>	
			<textarea name="content" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;">
				${boardVO.content }
			</textarea> 
			<input type="button" id="savebutton" value="수정완료" />
		</form>
		</div>
	</div>
</div>
</div>
</body>
</html>
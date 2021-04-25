<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
게시판 글쓰기 페이지입니다.

<!-- 서버안거치고 a 태그로 다이렉트로 보내는 건 권장하지않음, 컨트롤러에 지정하기 -->
<hr>

<form action="<%=request.getContextPath()%>/board/write-done" method="post">
<p>
	<input type="text" name="subject" placeholder="제목">
</p>
<p>
	<textarea rows="5" cols="500" name="content"></textarea>
</p>
<p>
	<button type="submit">등록</button>
</p>
</form>
	


</body>
</html>
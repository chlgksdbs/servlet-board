<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../components/header.jsp" %>
<script>
	alert("성공! 글 목록으로 돌아갑니다.");
	location.href="${root}/board?action=list";
</script>
<%@ include file="../../components/footer.jsp" %>
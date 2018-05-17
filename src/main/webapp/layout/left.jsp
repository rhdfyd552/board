<%@page import="kr.or.ddit.notice.service.NoticeServiceImpl"%>
<%@page import="kr.or.ddit.notice.service.NoticeServiceInf"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.notice.model.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/include/jQuery.jsp" %>
<% 
NoticeServiceInf service = NoticeServiceImpl.getInstance();
List<NoticeVO> noticeList = service.getNotice(); %>

<form action="${pageContext.request.contextPath}/getBoardList" name="frm">
<div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
          	<li><a href="${pageContext.request.contextPath }/getBoardList?category_seq=0">게시판 관리</a></li>
           <% for(NoticeVO vo : noticeList){
            	%><li><a href="${pageContext.request.contextPath }/getBoardList?no_seq=<%=vo.getNo_seq()%>"><%=vo.getNo_name()%></a></li><%
          }%>
          </ul>
          
        </div>
 </form>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<header>
        <div class="container-fluid">
            <div class="row">
                <div class="container">
                    <div class="navbar">
                        <div class="navbar-header">
                            
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="${pageContext.request.contextPath }"><img width="30" src="${pageContext.request.contextPath }/resources/img/logo.svg" alt="Brand"></a>
                        </div>

                        <div class="collapse navbar-collapse" id="myNavbar">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="${pageContext.request.contextPath }">Main</a></li>
                                <li><a href="${pageContext.request.contextPath }/freeBoard/freeList">자유게시판</a></li>
                                <li><a href="${pageContext.request.contextPath }/snsBoard/snsList">페이스북</a></li>
                            	<!-- 1중드롭다운(개발테스트중) -->
                            	<%-- 
                            	<li class="dropdown">
                            	    <a class="dropdown-toggle" data-toggle="dropdown" href="#">언어</a>
                                    <ul class="dropdown-menu">
                                        <li><a href="${pageContext.request.contextPath }/lecture/100/100">Java</a></li>
                                        <li><a href="${pageContext.request.contextPath }/lecture/200/200">JavaScript</a></li>
                                    	<li><a href="${pageContext.request.contextPath }/lecture/300/300">테스트</a></li>
                                    </ul>
                            	</li>
                            	--%>
                            	
                            	
                            	
                            	<%-- 
                            	<li class="dropdown drophover" ><!--drophover클래스를 주면 호버기능이 들어갑니다-->
                                    <a class="dropdown-toggle" id="dropdownMenu1" href="">강의</a>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                        <li>
                                        	<a href="${pageContext.request.contextPath }/lecture/java">JAVA</a>
                                        	<a href="${pageContext.request.contextPath }/lecture/java">JAVA</a>
                                        </li>
                                        <li>
                                        	<a href="${pageContext.request.contextPath }/lecture/java">C언어</a>
                                        </li>
                                    </ul>
                                </li>
                            	--%>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <!--드롭다운으로 로그인 추가 -->
                                <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">${sessionScope.user_id == null ? '로그인': '마이페이지' }
                                        <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                    	<c:choose>
                                    	<c:when test="${sessionScope.user_id == null }">	
                                        <li><a href="${pageContext.request.contextPath }/user/userJoin"><span class="glyphicon glyphicon-user"></span>Join</a></li>
                                        <li><a href="${pageContext.request.contextPath }/user/userLogin"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
                                        <li><a href="${pageContext.request.contextPath }/user/userMypage"><span class="glyphicon glyphicon-user"></span>MyPage</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li><a href="${pageContext.request.contextPath }/user/userMypage"><span class="glyphicon glyphicon-user"></span>MyPage</a></li>
                                        <li><a href="${pageContext.request.contextPath }/user/userLogout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
                                        </c:otherwise>
                                        </c:choose>
                                    </ul>
                                </li>
                            </ul>

                            <form class="navbar-form navbar-right" action="">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Search">
                                    <div class="input-group-btn">
                                        
                                        <button class="btn btn-primary" type="submit">
                                           	 검색
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>

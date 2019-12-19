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
                            	<%--
                            	<li class="dropdown">
                            	    <a class="dropdown-toggle" data-toggle="dropdown" href="#">언어</a>
	                            	<ul class="dropdown-menu">
				                        <li class="dropdown-submenu">
				                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown</a>
				                            <ul class="dropdown-menu">
				                                <li><a href="#">Action</a></li>
				                                <li><a href="#">Another action</a></li>
				                                <li><a href="#">Something else here</a></li>
				                            </ul>
				                        </li>
				                    </ul>
                            	</li>
                            	--%>
                            	<!-- 1중드롭다운 -->
                            	<li class="dropdown">
                            	    <a class="dropdown-toggle" data-toggle="dropdown" href="#">언어</a>
                                    <ul class="dropdown-menu">
                                        <li>
                                        	<a href="${pageContext.request.contextPath }/lecture/100/100">Java</a>
                                        	<a href="${pageContext.request.contextPath }/lecture/100/101"><i class="glyphicon glyphicon-minus"></i>주석 식별자</a>
                                        	<a href="${pageContext.request.contextPath }/lecture/100/102"><i class="glyphicon glyphicon-minus"></i>변수</a>
                                        	<a href="${pageContext.request.contextPath }/lecture/100/103"><i class="glyphicon glyphicon-minus"></i>데이터타입</a>
                                        	<a href="${pageContext.request.contextPath }/lecture/100/104"><i class="glyphicon glyphicon-minus"></i>형변환</a>
                                        	<a href="${pageContext.request.contextPath }/lecture/100/105"><i class="glyphicon glyphicon-minus"></i>연산자</a>
                                        	<a href="${pageContext.request.contextPath }/lecture/100/105"><i class="glyphicon glyphicon-minus"></i>배열</a>
                                        	<a href="${pageContext.request.contextPath }/lecture/100/105"><i class="glyphicon glyphicon-minus"></i>출력(스캐너)</a>
                                        	<a href="${pageContext.request.contextPath }/lecture/100/105"><i class="glyphicon glyphicon-minus"></i>조건문</a>
                                        	<a href="${pageContext.request.contextPath }/lecture/100/105"><i class="glyphicon glyphicon-minus"></i>반복문</a>
                                        	<a href="${pageContext.request.contextPath }/lecture/100/105"><i class="glyphicon glyphicon-minus"></i>탈출문</a>
                                        </li>
                                        <li><a href="${pageContext.request.contextPath }/lecture/200/200">JavaScript</a></li>
                                    	
                                    </ul>
                            	</li>
                            	
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                            <a class="navbar-brand" href="${pageContext.request.contextPath }/"><img width="30" src="${pageContext.request.contextPath }/resources/img/logo.svg" alt="Brand"></a>
                        </div>

                        <div class="collapse navbar-collapse" id="myNavbar">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="${pageContext.request.contextPath }/">Main</a></li>
                                <li><a href="${pageContext.request.contextPath }/freeBoard/freeList">자유게시판</a></li>
                                <li><a href="#">자료실</a></li>
                                <!-- 
                                <li><a href="#">Form</a></li>
                                <li><a href="#">Board</a></li>
 								-->
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <!--드롭다운으로 로그인 추가 -->
                                <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">로그인
                                        <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#"><span class="glyphicon glyphicon-user"></span>Join</a></li>
                                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
                                        <li><a href="#"><span class="glyphicon glyphicon-user"></span>MyPage</a></li>
                                        <li><a href="#"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
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

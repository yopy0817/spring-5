<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<aside class="col-xs-12 col-sm-3 col-md-3">
	<%-- 
	<div class="menu1">
		<c:choose>
			<c:when test="${sessionScope.user_id != null }">
				<p>
					<img src="../resources/img/profile.png">${userVO.userName }
				</p>
				<ul>
					<li>내정보</li>
					<li>내쿠폰</li>
					<li>내좋아요게시물</li>
				</ul>
			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-info"
					onclick="location.href='../user/userLogin'">로그인</button>
			</c:otherwise>
		</c:choose>
	</div>
	--%>
	<div class="menu2">
		<div class="depth0">${lecVO.lecName }</div>
		<ul>
			<c:forEach var="vo" items="${lecVO.lectureListVO }">
				<li	class="depth1 ${vo.lecListName eq lecListVO.lecListName ? 'select':'' }">
					<a href="${vo.lecListNo}">${vo.lecListName }</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</aside>
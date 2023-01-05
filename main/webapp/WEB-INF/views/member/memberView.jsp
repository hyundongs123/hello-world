<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="com.sh.mvc.member.model.dto.Gender"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%
	String memberId = loginMember.getMemberId();
	String memberName = loginMember.getMemberName();
	Date _birthday = loginMember.getBirthday();
	SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
	String birthday = transFormat.format(_birthday);
	String email = loginMember.getEmail();
	String phone = loginMember.getPhone();
	int point = loginMember.getPoint();
	String gender = loginMember.getGender().name();
		// 운동 , 등산 , 독서,  게임 여행
%>




<section id=enroll-container>
	<h2>회원 정보</h2>
	
	<form name="memberUpdateFrm" method="post" 	action="<%= request.getContextPath() %>/member/memberUpdate">
		<table>
			<tr>
				<th>아이디<sup>*</sup></th>
				<td>
					<input type="text" name="memberId" id="memberId" value="<%=memberId %>" readonly>
				</td>
			</tr>
			<tr>
				<th>이름<sup>*</sup></th>
				<td>	
				<input type="text"  name="memberName" id="memberName" value="<%=memberName %>"  required><br>
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>	
				<input type="date" name="birthday" id="birthday" value="<%=birthday%>"> <br>
				</td>
			</tr> 
			<tr>
				<th>이메일</th>
				<td>	
					<input type="email" placeholder="abc@xyz.com" name="email" id="email" value="<%=email != null ? email : "" %>"><br>
				</td>
			</tr>
			<tr>
				<th>휴대폰<sup>*</sup></th>
				<td>	
					<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" value="<%=phone %>" required><br>
				</td>
			</tr>
			<tr>
				<th>포인트</th>
				<td>	
					<input type="text" placeholder="" name="point" id="point" value="<%=point %>" readonly><br>
				</td>
			</tr>
			<tr>
				<th>성별 </th>
				<td>
				
			       		 <input type="radio" name="gender" id="gender0" value="M" <%=loginMember.getGender() == Gender.M ? "checked" : ""  %>>
						 <label for="gender0">남</label>
						 <input type="radio" name="gender" id="gender1" value="F" <%=loginMember.getGender() == Gender.F ? "checked" : ""  %>>
						 <label for="gender1">여</label>
						 
				</td>
			</tr>
			<tr>
<%
	String hobby = loginMember.getHobby();
	List<String> hobbyList = null;// nullable 널이 넘어올 수 있다.
	if(hobby != null){
    hobbyList  = Arrays.asList(hobby.split(","));
}
%>			
				<th>취미 </th>
				<td>
				
					<input type="checkbox" name="hobby" id="hobby0" value="운동"<%= hobbyList != null && hobbyList.contains("운동") ? "checked" : "" %> ><label for="hobby0">운동</label>
					<input type="checkbox" name="hobby" id="hobby1" value="등산"<%= hobbyList != null && hobbyList.contains("등산") ? "checked" : "" %> ><label for="hobby1">등산</label>
					<input type="checkbox" name="hobby" id="hobby2" value="독서"<%= hobbyList != null && hobbyList.contains("독서") ? "checked" : "" %> ><label for="hobby2">독서</label><br />
					<input type="checkbox" name="hobby" id="hobby3" value="게임"<%= hobbyList != null && hobbyList.contains("게임") ? "checked" : "" %> ><label for="hobby3">게임</label>
					<input type="checkbox" name="hobby" id="hobby4" value="여행"<%= hobbyList != null && hobbyList.contains("여행") ? "checked" : "" %> ><label for="hobby4">여행</label><br />

				</td>
			</tr>
		</table>
		
        <input type="submit" value="정보수정" />
        <input type="button" value ="비밀번호변경" onclick="updatePassword();" />
		<form action="" type="hidden"></form>
        <input type="button" onclick="deleteMember();" method="post"value="탈퇴"/>
	</form>
</section>
<form action="<%=request.getContextPath()%>/member/memberDelete" method="post" name ="memberDeleteFrm"></form>

<script>
/* 
	기존비밀번호입력
	새비밀번호/비밀번호확인
	
	기존비밀번호가 일치하면 , 새비밀번호 업데이트
	기존비밀번호가 일치하면 , 새비밀번호 업데이트 취소 
	
	GET   /mvc/member/updatePassword  비밀번호 변경 form 폼요청
	POST  /mvc/member/updatePassword  db비밀번호 변경 요청
*/
	
const deleteMember=()=>{
		
	 if (confirm("정말회원을 탈퇴하시겠습니까 ?")) {
	document.memberDeleteFrm.submit();
	 }else{
		location.href ="<%=request.getContextPath()%>/member/memberView"
     }
	
	}
	
	const updatePassword =()=>{
		location.href ="<%=request.getContextPath()%>/member/updatePassword";
	}
	
	document.memberUpdateFrm.onsubmit = (e) => {
    const memberName = document.querySelector("#memberName");
    const phone = document.querySelector("#phone");

 
    // 이름 - 한글 2글자이상
    if(!/^[가-힣]{2,}$/.test(memberName.value)){
        alert("이름은 한글 2글자 이상이어야 합니다.")
        memberName.select();
        return false;
    }

    // 전화번호 숫자 01012345678
    if(!/^010[0-9]{8}$/.test(phone.value)){
        alert("전화번호가 유효하지 않습니다.")
        phone.select();
        return false;
    }
};

</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>

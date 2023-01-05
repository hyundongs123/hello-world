package com.sh.mvc.member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sh.mvc.member.model.dto.Gender;
import com.sh.mvc.member.model.dto.Member;
import com.sh.mvc.member.model.service.MemberService;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/member/memberUpdate")
public class MemberUpdateServlet extends HttpServlet {
	private MemberService memberService = new MemberService();
	private static final long serialVersionUID = 1L;
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int result = 0;

		HttpSession session = request.getSession();
//		update  member set  member_name = ? ,birthday = ? ,email = ? , phone = ? ,  point = ? , gender = ?, hobby = ?    where  member_id = ? ;
		try{
			String memberId = request.getParameter("memberId");
			String memberName = request.getParameter("memberName");
			
			
			String _birthday = request.getParameter("birthday"); //1988-08-08
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			int point = Integer.parseInt(request.getParameter("point"));
			String _gender = request.getParameter("gender");
			String [] _hobby = request.getParameterValues("hobby");
			
			Date birthday =!"".equals(_birthday) ?  Date.valueOf(_birthday) : null;
			Gender gender = _gender != null ? Gender.valueOf(_gender) : null;
			String hobby = _hobby != null ? String.join(",", _hobby) : null;
			
			Member member = new Member(memberId, memberName, gender, birthday, email, phone, hobby, point);
			
			result = memberService.updateMember(member);
		
			// 회원가입성공 메세지
			if(result > 0) {
				session.setAttribute("msg", "정보업데이트에 성공하셨습니다.");
				
		//세션정보 갱신
				session.setAttribute("loginMember", memberService.selectOneMember(memberId));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("msg", "정보업데이트에 실패하셨습니다.");
			
		}
		
		response.sendRedirect(request.getContextPath() + "/member/memberView"); // 클라이언트가 다시 요청할 주소
		
	}

}

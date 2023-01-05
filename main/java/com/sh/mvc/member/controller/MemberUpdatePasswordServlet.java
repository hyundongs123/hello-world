package com.sh.mvc.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sh.mvc.common.HelloMvcUtils;
import com.sh.mvc.member.model.dto.Member;
import com.sh.mvc.member.model.service.MemberService;

/**
 * Servlet implementation class MemberUpdatePasswordServlet
 */
@WebServlet("/member/updatePassword")
public class MemberUpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/updatePassword.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("비밀번호업데이트 -----------");
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		String location = request.getContextPath();
		String memberId = loginMember.getMemberId();
		
		System.out.println(memberId);
		
		String oldPassword = HelloMvcUtils.getEncryptedPssword(request.getParameter("oldPassword"), memberId);
		String newPassword = HelloMvcUtils.getEncryptedPssword(request.getParameter("newPassword"), memberId);
		
		//2.기존비밀번호 일치여부검사
		//db에 있는 비밀번호와 비교 / session의 비밀번호와 비교
		boolean passed = false; // 기존비밀번호가 일치하는가 
		
		if(oldPassword == loginMember.getPassword()); 
			passed =true ;
		// 3. 업무로직
		
		System.out.println(passed);
		
		if(passed) {
			//신규비밀번호 업데이트 update 쿼리 sql  update member set password = ? where  member_id = ? 
			//비밀번호변경 성공 메시지 $리다에릭트
			
			//업데이트 쿼리 update member set password = ?  where = ? 
				memberService.memberUpdatePassword(memberId,newPassword);
				session.setAttribute("msg", "비밀번호변경에 성공하셨습니다.");
				
				session.setAttribute("loginMember", memberService.selectOneMember(memberId));
				//세션 정보 갱신
				response.sendRedirect(request.getContextPath()+"/member/memberView");
				System.out.println("업데이트성공");
		}else {
			//기존비밀번호 틀림 메시지 %리다이렉트 
			response.sendRedirect(request.getContextPath()+"/member/updatePassword");
			System.out.println("업데이트 실패");
		}
		
		
		
		
		
	}

}

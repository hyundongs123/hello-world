package com.sh.mvc.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sh.mvc.member.model.service.MemberService;

/**
 * Servlet implementation class AdminUpdateMemberRole
 */
@WebServlet("/admin/updateMemberRole")
public class AdminUpdateMemberRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService memberService =new MemberService();

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try{
		String memberId = request.getParameter("memberId");
		String memberRole = request.getParameter("memberRole");
		
		int result = memberService.updateMemberRole(memberId,memberRole);
		if (result > 0)
			session.setAttribute("msg", "회원권한 업데이트 완료");
		
		}catch (Exception e) {
			session.setAttribute("msg", "회원권한 업데이트 실패");
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/admin/memberList");

	}

}

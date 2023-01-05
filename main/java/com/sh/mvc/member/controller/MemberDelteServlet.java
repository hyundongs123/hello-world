package com.sh.mvc.member.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sh.mvc.member.model.dto.Member;
import com.sh.mvc.member.model.service.MemberService;

/**
 * Servlet implementation class MemberDelteServlet
 */
@WebServlet("/member/deleteMember")
public class MemberDelteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberService memberService = new MemberService();
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		try {
			
			int result = 0; 
			Member loginMember =(Member)session.getAttribute("loginMember");
			String memberId =loginMember.getMemberId();
			
			System.out.println(memberId);
			
			result =memberService.delteMember(memberId);
			// 모든속성 제거하기 .
			Enumeration<String> names = session.getAttributeNames();
			while(names.hasMoreElements()) {
				String name = names.nextElement();
				session.removeAttribute(name);
			}
			
			Cookie c = new Cookie("saveId",memberId);
			c.setPath(request.getContextPath());
			c.setMaxAge(0);
			response.addCookie(c);
			
			
			session.setAttribute("msg", "회원 탈퇴에 성공하셨습니다.");
			response.sendRedirect(request.getContextPath()+"/");
			
			
		} catch (Exception e) {
			session.setAttribute("msg", "회원 탈퇴에 실패하셨습니다.");
			e.printStackTrace();
		}
		
	}

}

package com.sh.mvc.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.mvc.member.model.dto.Member;
import com.sh.mvc.member.model.service.MemberService;

/**
 * Servlet implementation class AdminMemberFinderServlet
 */
@WebServlet("/admin/memberFinder")
public class AdminMemberFinderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		System.out.println(searchType);
		System.out.println(searchKeyword);
		
		Map <String,String> param  = new HashMap<>();
		param.put("searchType",searchType);
		param.put("searchKeyword", searchKeyword);
		
		System.out.println("Param = "+param);
		
	//2.업무로직 회원검색
		List<Member> members = memberService.serachMember(param);
		System.out.println(members);
	
		
		request.setAttribute("members", members);
		request.getRequestDispatcher("/WEB-INF/views/admin/memberList.jsp")
		.forward(request, response);
		
	}

}

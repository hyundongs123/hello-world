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

import com.sh.mvc.common.HelloMvcUtils;
import com.sh.mvc.member.model.dto.Member;
import com.sh.mvc.member.model.service.MemberService;

/**
 * 1.content 영역
 * - sql문
 * - 현재페이지                              
 * - 한페이지당 게시물수                        
 * 
 * 2.pagebar 영역
 * - 총게시물수
 * - 페이지수
 * - 페이지바의 크기 
 * - 현재페이지 
 * - url 
 * 
 * 
 */

@WebServlet("/admin/memberList")  
public class AdminMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private MemberService memberService = new MemberService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.사용자 입력값 처리
		final int  limit = 10;
		int page = 1;
		
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			//NumberForamtExecption  이 발생했지만 , 기본값은 1로 처리. 예외는 무시해버리겠다.
		}
		
		Map<String, Object> param =new HashMap<>();
		param.put("page",page);
		param.put("limit", limit);
		System.out.println("Params = "+param);
		
		
		
		//2.업무로직 
		//a. content 영역
		List<Member> members = memberService.selectAllMember(param);
		System.out.println(members);
		//b. pagebqr 영역
		
		int totalCount = memberService.selectTotalCount();
		
		System.out.println(totalCount);
		String url = request.getRequestURI();
		String pagebar = HelloMvcUtils.getPagebar(page,limit,totalCount,url);
		System.out.println(pagebar);
		
		
		//3. view단처리
		request.setAttribute("members", members);
		request.setAttribute("pagebar", pagebar);
		request.getRequestDispatcher("/WEB-INF/views/admin/memberList.jsp")
		.forward(request, response);
		
	}
	
	
}

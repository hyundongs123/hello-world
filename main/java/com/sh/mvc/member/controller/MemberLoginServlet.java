package com.sh.mvc.member.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sh.mvc.common.HelloMvcUtils;
import com.sh.mvc.member.model.dto.Member;
import com.sh.mvc.member.model.service.MemberService;

/**
 * http통신은 무상태지향 stateless 지향 프로토콜이다.
 * 매번 요청 /응답 독립적이다. 이전 요청과 연결되지 않는다. 
 * 클라이언트의 상태 유지 메커니즘으로 session .Cookie이다.
 * 
 * -session 상태유지 필요한 정보를 server에 보관
 * -cookie 상태유지 필요한 정보를 clinet에 보관
 * 
 * - 1.서버는 클라이언트의 최초 요청시 session객체를 생성(session id)
 * - 2.생성된 session의 id를 응답에 전송 (Set-Cookie헤더)
 * - 3.클라이언트는 cookie로 브라우져 내에 보관 (JsessionID =12341234222s2afg)
 * - 4.클라이언트는 이후 요청마다 JSESSIONID쿠키를 함께 전송
 * - 5.서버 요청이 올때마다 JSESSIONID확인 존재하는 session객체와 연결시킴.
 * 		-SSESSIONID가 없거나 유효하지 않으면 1번실행.
 * 
 * 세션객체의 기본유효시간 30분 ..마지막요청으로부터
 * 
 * 
 */
@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩처리
		request.setCharacterEncoding("utf-8");
		
		// 2. 사용자입력값 가져오기
		String memberId =request.getParameter("memberId");
		String password =HelloMvcUtils.getEncryptedPssword(request.getParameter("password"), memberId);
		String saveId =request.getParameter("saveId");
		
		System.out.println("memberId = "+memberId);
		System.out.println("password = "+password);
		System.out.println("saveId = "+saveId);
		// 3. 업무로직
		Member member = memberService.selectOneMember(memberId);
		System.out.println("member ="+member);
		
		HttpSession session = request.getSession();
		System.out.println("id = "+session.getId());
		System.out.println("유효시간 = "+session.getMaxInactiveInterval());  //초 60*30
		System.out.println("생성시각 = "+new Date(session.getCreationTime()));
		System.out.println("마지막접속시간 = "+new Date(session.getLastAccessedTime())); // 이번말고 최근접속시각
		
		
		if(member!=null && password.equals(member.getPassword())) {
			//HttpSession객체 -접속한 클라이언트별로 (브라우저)제공되는 객체
			session.setAttribute("loginMember", member);
			
			Cookie cookie = new Cookie("saveId",memberId);
			cookie.setPath(request.getContextPath());   // cookie를 전송할 url설정 ,지정한 url하위경로에 모두전송 //, /mvc/, /abc/d/e,
			//유효시간 setMaxAge, setExpire
			if(saveId != null) {
				//아이디저장 체크한경우
				//유효시간 설정하지 않으면 session-cookie로 작동 (브라우져끄면 제거)
				//유효시간 설정하면 , persistent -cookie로 작동(지정한 기간동안 저장);
				cookie.setMaxAge(60*60*24*7); //7일간 클라이언트에 저장
			}else {
				//아이디저장 체크해제한경우
				cookie.setMaxAge(0);// 즉시 삭제
			}
			response.addCookie(cookie);
			
			
		}else {
			session.setAttribute("msg", "아이디가 존재하지 않거나 비밀번호가 틀립니다.");
			
			//
		}
			
		// 4. view단처리 -redirect (url변경 - 새로고침 안되도록)
		response.sendRedirect(request.getContextPath() + "/"); //클라이언트가 다시 요청할 주소
			
		
		
		
	
	
	}

}

package com.sh.mvc.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.mvc.board.model.dto.BoardComment;
import com.sh.mvc.board.model.service.BoardService;

/**
 * Servlet implementation class BoardCommentEnrollServlet
 */
@WebServlet("/board/boardCommentEnroll")
public class BoardCommentEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService =new BoardService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 사용자 입력값처리
		BoardComment bc = new BoardComment();
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		int commentLevel = Integer.parseInt(request.getParameter("commentLevel"));
		int commentRef = Integer.parseInt(request.getParameter("commentRef"));
		
		bc.setBoardNo(boardNo);
		bc.setWriter(writer);
		bc.setContent(content);
		bc.setCommentLevel(commentLevel);
		bc.setCommentRef(commentRef);
		
		//2. 업무 로직 board_comment 한행추가
		//dao에서 comment_ref 컬럼값 세팅시, setObject를 사용해서 0이면 null을 대입할수 있도록 한다.
		int result = boardService.insertBoardComment(bc);
		
		// insert into board_comment values (? ,? ,?)
		
		//3. 뤼다이렉트  /board/boardView
		
//		String referer =request.getHeader("Referer");

//		System.out.println(referer);
		
		response.sendRedirect(request.getContextPath()+"/board/boardView?no="+boardNo); //클라이언트가 다시 요청할 주소
	}

}

package com.sh.mvc.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.mvc.board.model.service.BoardService;

/**
 * Servlet implementation class BoardCommentDeleteServlet
 */
@WebServlet("/board/boarddeletecomment")
public class BoardCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService = new BoardService();
	
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시물 댓글 삭제");
		System.out.println("--★--★--★--★--★--★--★--★--★--★--★--★--★--★--★--★--★--★--★--★--★--★--★--★--★--★--★--★--★--★ㅍㅍㅍ");
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
    	
		
		int result = boardService.boardCommentDelete(no);
		
		response.sendRedirect(request.getContextPath()+"/board/boardList");
			
		
	}

}

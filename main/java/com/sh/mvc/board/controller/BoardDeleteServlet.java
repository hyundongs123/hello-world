package com.sh.mvc.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.mvc.board.model.dto.Attachment;
import com.sh.mvc.board.model.service.BoardService;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/board/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardService();
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("no = "+no);
		
		
		//3. 저장된 첨부파일삭제
		List<Attachment> attachments = boardService.selectAttachmentByBoardNo(no);
		String saveDirectory = getServletContext().getRealPath("/upload/board");
		
		for(Attachment attach : attachments) {
			File delFile = new File(saveDirectory,attach.getRenamedFilename());
			boolean bool = delFile.delete();
			System.out.println(bool ? "파일삭제 성공 " : "파일 삭제 실패 !");
		}
		
		//2. 업무로직 board삭제 attachment 삭제
		//delete board where no = ? 
		int result = boardService.deleteBoard(no);
		
		//4. redirect : /board/boardList
		request.getSession().setAttribute("msg", "게시글을 성공적으로 삭제했습니다.");
		response.sendRedirect(request.getContextPath()+"/board/boardList");
		
		
		
		
		
		
	}

}

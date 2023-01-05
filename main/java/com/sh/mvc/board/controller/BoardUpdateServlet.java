package com.sh.mvc.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.sh.mvc.board.model.dto.Attachment;
import com.sh.mvc.board.model.dto.Board;
import com.sh.mvc.board.model.service.BoardService;
import com.sh.mvc.common.HelloMvcFileRenamePolicy;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/board/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardService();
	int no;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		no = Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
		Board board = boardService.selectOneBoard(no);
		request.setAttribute("board", board);
		request.getRequestDispatcher("/WEB-INF/views/board/boardUpdate.jsp").forward(request, response);
		
	}
	
	
	/**
	 * 첨부파일이 포함된 게시물 수정 
	 * 
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String saveDirectory =  getServletContext().getRealPath("/upload/board"); //웹루트디렉토리(src/main/webapp)부터 탐색
			System.out.println(saveDirectory);
			int maxPostSize = 100*1024*1024;
			String encoding = "utf-8";
			
//		FileRenamePolicy policy = new DefaultFileRenamePolicy();//중복파일이 있는경우 , abc1.txt abc2.txt .... 
			FileRenamePolicy policy = new HelloMvcFileRenamePolicy();//년월일_시분초밀리초_난수.txt 
			
			System.out.println("첨부파일 되는지확인");
			
			
			
			int result =0;
			MultipartRequest multiReq = new MultipartRequest(request, saveDirectory ,maxPostSize , encoding, policy);
			
			String title = multiReq.getParameter("title");
			String content = multiReq.getParameter("content");
			
			Board board = new Board();
			board.setNo(no);
			board.setContent(content);
			board.setTitle(title);
			if(multiReq.getFile("upFile1")!=null) {
				Attachment attach = new Attachment();
				attach.setOriginalFilename(multiReq.getOriginalFileName("upFile1"));
				attach.setRenamedFilename(multiReq.getFilesystemName("upFile1"));
				board.addAttachment(attach);
				
			}
			if(multiReq.getFile("upFile2")!=null) {
				Attachment attach = new Attachment();
				attach.setOriginalFilename(multiReq.getOriginalFileName("upFile2"));
				attach.setRenamedFilename(multiReq.getFilesystemName("upFile2"));
				board.addAttachment(attach);
			}
			
			
			
			result =  boardService.boardUpdate(board);
			System.out.println("수정성공!!!");
			if(result>0)
			request.getSession().setAttribute("msg", "게시글을 성공적으로 수정하였습니다..");
		} catch (NumberFormatException e) {
			request.getSession().setAttribute("msg", "게시글을 수정 실패!!");
			e.printStackTrace();
		}
			response.sendRedirect(request.getContextPath()+"/board/boardList");
	
	}

	
	
	
	
}

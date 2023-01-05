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
 * Servlet implementation class BoardEnrollServlet
 */
@WebServlet("/board/boardEnroll")
public class BoardEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.getRequestDispatcher("/WEB-INF/views/board/boardEnroll.jsp")
	.forward(request, response);
	
	}
	/**
	 * 파일업로드가 포함된 post 요청
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			//0.MultipartRequest 객체 생성 - 요청메세지에서 파일을 읽어 (input), 서버컴퓨터에 저장(Output)까지 처리.
			String saveDirectory =  getServletContext().getRealPath("/upload/board"); //웹루트디렉토리(src/main/webapp)부터 탐색
			System.out.println(saveDirectory);
			int maxPostSize = 100*1024*1024;
			String encoding = "utf-8";
			
//		FileRenamePolicy policy = new DefaultFileRenamePolicy();//중복파일이 있는경우 , abc1.txt abc2.txt .... 
			FileRenamePolicy policy = new HelloMvcFileRenamePolicy();//년월일_시분초밀리초_난수.txt 
			
			System.out.println("첨부파일 되는지확인");
			
			//MultipartRequest (HttpServletRequest request ,String saveDirectory, int maxPostSize , String encoding , FileRenamePolicy policy)
			MultipartRequest multiReq = new MultipartRequest(request, saveDirectory ,maxPostSize , encoding, policy);
			
			
			System.out.println("-----------------------------------------------------------========================================================================");
			//입력값
			String title = multiReq.getParameter("title");
			String writer = multiReq.getParameter("writer");
			String content = multiReq.getParameter("content");
			
			
			Board board = new Board();
			board.setTitle(title);
			board.setWriter(writer);
			board.setContent(content);
			
			
			
			//업로드한 파일처리 
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
			System.out.println(board);
			
			int result = 0 ;
			
			
			result = boardService.insertBoard(board);
			
			
			System.out.println(board);
			response.sendRedirect(request.getContextPath()+"/board/boardView?no="+board.getNo());
			//3.리다이렉트
		} catch (IOException e) {
			e.printStackTrace();
			request.getSession().setAttribute("msg","게시글등록중 오류가 발생했습니다.");
			response.sendRedirect(request.getContextPath()+"/board/boardList");
		}
	
		
	
	}

}

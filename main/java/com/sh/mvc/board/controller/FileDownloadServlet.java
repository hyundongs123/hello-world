package com.sh.mvc.board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.mvc.board.model.dto.Attachment;
import com.sh.mvc.board.model.service.BoardService;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/board/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService =new BoardService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//사용자 입력값
		int no = Integer.parseInt(request.getParameter("no"));
		
		System.out.println(no);
		
		//업무로직
		Attachment attach = boardService.selectOneAttachment(no);
		System.out.println("attach = "+attach);
		
		//응답메시지
		
		//응답 헤더 작성 다운로드할 파일명 originalfilename 
		
		String filename = URLEncoder.encode(attach.getOriginalFilename(),"utf-8"); //한글파일 인코더
		System.out.println("fileName ="+filename);
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename="+filename);
		
		//실제파일을 읽어서 http응답메시지에 쓰기 
		String saveDirectory = getServletContext().getRealPath("/upload/board");
		File downFile =new File(saveDirectory,attach.getRenamedFilename());
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(downFile));
		BufferedOutputStream bos = new BufferedOutputStream (response.getOutputStream());
		
		//읽고 쓰기
		
		int len = -1 ;
		byte[] buffer = new byte[8192]; //한번에 처리할 byte수
		
		while((len = bis.read(buffer)) != -1) {
			bos.write(buffer,0,len);
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}

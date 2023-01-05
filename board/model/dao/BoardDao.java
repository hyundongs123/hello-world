package com.sh.mvc.board.model.dao;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.sh.mvc.board.model.dto.Attachment;
import com.sh.mvc.board.model.dto.Board;
import com.sh.mvc.board.model.dto.BoardComment;
import com.sh.mvc.board.model.exception.BoardException;

public class BoardDao {
	
	private Properties prop = new Properties();
	
	public BoardDao() {
		String path = BoardDao.class.getResource("/sql/board/board-query.properties").getPath();
		try {
			prop.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("BoardDao 쿼리 로드 완료! - " + prop);
	}

	public List<Board> selectBoardList(Connection conn, Map<String, Object> param) {
		String sql = prop.getProperty("selectBoardList");
		List<Board> boardList = new ArrayList<>();
		
		int page = (int) param.get("page"); 
		int limit = (int) param.get("limit"); // 5
		
		int start = (page - 1) * limit + 1; // 1, 6, 11, 16, ... 
		int end = page * limit; // 5, 10, 15, 20, ...
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			try(ResultSet rset = pstmt.executeQuery()){
				
				while(rset.next()) {
					Board board = handleBoardResultSet(rset);
					board.setAttachCnt(rset.getInt("attach_cnt"));
					boardList.add(board);					
				}
			}
			
		} catch (SQLException e) {
			throw new BoardException("게시글 목록 조회 오류!", e);
		}
		
		return boardList;
	}

	private Board handleBoardResultSet(ResultSet rset) throws SQLException {
		Board board = new Board();
		board.setNo(rset.getInt("no"));
		board.setTitle(rset.getString("title"));
		board.setWriter(rset.getString("writer"));
		board.setContent(rset.getString("content"));
		board.setReadCount(rset.getInt("read_count"));
		board.setRegDate(rset.getDate("reg_date"));
		return board;
	}

	public int selectTotalCount(Connection conn) {
		String sql = prop.getProperty("selectTotalCount");
		int totalCount = 0;
		
		try (
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery();
		){
			if(rset.next()) {
				totalCount = rset.getInt(1);
			}
		} catch (Exception e) {
			throw new BoardException("전체 게시글수 조회 오류!", e);
		}
		return totalCount;
	}

	public int insertBoard(Connection conn,Board board) {
		
		String sql =prop.getProperty("insertBoard");
		int result =0 ;
		try(PreparedStatement pstmt =conn.prepareStatement(sql)){
		
		
			pstmt.setString(1,board.getTitle());
			pstmt.setString(2,board.getWriter());
			pstmt.setString(3,board.getContent());
		
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			throw new BoardException("게시글 등록 오류",e);
			
		}
		return result;
	}

	public int selectLastBoardNo(Connection conn) {
		
		String sql = prop.getProperty("selectLastBoardNo");
		int boardNo =0;
		
		try (
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery();
				
				){
			
			if(rset.next()) {
				boardNo = rset.getInt(1);
			}
		} catch (SQLException e) {
		throw new BoardException("게시글번호 조회 오류 ",e);
		}
		// TODO Auto-generated method stub
		return boardNo;
	}

	public int insertAttachment(Connection conn, Attachment attach) {
		// TODO Auto-generated method stubinsertA
		
		String sql = prop.getProperty("insertAttachment");
		int result = 0;
		
		try(
			PreparedStatement pstmt =conn.prepareStatement(sql);
				){
			pstmt.setInt(1, attach.getBoardNo());
			pstmt.setString(2, attach.getOriginalFilename());
			pstmt.setString(3, attach.getRenamedFilename());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw new BoardException("첨부파일 등록 오류 !",e);
		}
		
		return result;
	}

	public Board selectOneBoard(Connection conn, int no) {
		String sql = prop.getProperty("selectOneBoard");
		Board board = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)
				){
			pstmt.setInt(1, no);
			
			try(ResultSet rset = pstmt.executeQuery()){
				while(rset.next()) {
				 board =	handleBoardResultSet(rset);
				}
			}
		}catch(Exception e) {
			throw new BoardException("게시글 한건 조회 오류! ",e);
			
		}
		
		
		return board;
	}

	public List<Attachment> selectAttachmentByBoardNo(Connection conn, int  boardNo) {

		String sql = prop.getProperty("selectAttachmentByBoardNo");
		Board board = null;
		//select *from attachment where board_no = ?
		List<Attachment> attachments = new ArrayList<>();
		try(PreparedStatement pstmt = conn.prepareStatement(sql)
				){
			pstmt.setInt(1, boardNo);
			
			try(ResultSet rset = pstmt.executeQuery()){
				while(rset.next()) {
				Attachment attach = handleAttachmentResultSet(rset);
			
				attachments.add(attach);
				}
			}
		}catch(Exception e) {
			throw new BoardException("게시글 한건 조회 오류! ",e);
			
			
		}
		return attachments;
	}

	private Attachment handleAttachmentResultSet(ResultSet rset) throws SQLException {
		Attachment attach = new Attachment();
		attach.setNo(rset.getInt("no"));
		attach.setBoardNo(rset.getInt("board_no"));
		attach.setOriginalFilename(rset.getString("original_filename"));
		attach.setRenamedFilename(rset.getString("renamed_filename"));
		attach.setRegDate(rset.getDate("reg_date"));
		return attach;
	}
	

	public int boardCount(Connection conn, int no) {
		String sql =  prop.getProperty("boardCount");
		int result = 0;
		try(
				PreparedStatement pstmt =conn.prepareStatement(sql);
					){
				pstmt.setInt(1, no);
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				throw new BoardException("조회수 증가 오류! ",e);
			}
			return result;
	}

	public Attachment selectOneAttachment(int no, Connection conn) {
		String sql = prop.getProperty("selectOneAttachment");
		Attachment attach = null;
		//selectOneAttachment = select * from attachment where no = ?
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, no);
			try(ResultSet rset = pstmt.executeQuery()){
				while(rset.next()) {
				attach=	handleAttachmentResultSet(rset);
				}
			}
			
		} catch (Exception e) {
			throw new BoardException("첨부파일 한건 조회 오류! ",e);
		}
		
		return attach;
	}

	public int deleteBoard(Connection conn, int no) {
		String sql = prop.getProperty("deleteBoard"); //delete from board where no = ?
		int result = 0;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			throw new BoardException("게시글 삭제 오류",e);
		}
		return result;
	}

	public int boardUpdate(Connection conn, Board board) {
		String sql = prop.getProperty("updateBoard");// update from board set title = ? ,content = ? where no = ?
		int result =0 ;
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, board.getTitle());
				pstmt.setString(2, board.getContent());
				pstmt.setInt(3, board.getNo());
				result = pstmt.executeUpdate();
					
		} catch (Exception e) {
			throw new BoardException("게시물 수정 오류 !",e);
		}
		return result;
	}

	public int deleteAttachment(Connection conn, int attachNo) {
		String sql = prop.getProperty("deleteAttachment");
		
		int result = 0 ;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, attachNo);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new BoardException ("첨부파일 삭제 오류!",e);
			
		}
		
		
		return result;
	}

	public List<BoardComment> selectBoardCommentList(Connection conn, int boardNo) {
		String sql = prop.getProperty("selectBoardCommentList");
		
		List<BoardComment> comments = new ArrayList<>();
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, boardNo);
			try(ResultSet rset = pstmt.executeQuery()){
				while(rset.next()) {
					BoardComment bc = new BoardComment();
					bc.setNo(rset.getInt("no"));
					bc.setCommentLevel(rset.getInt("comment_level"));
					bc.setWriter(rset.getString("writer"));
					bc.setContent(rset.getString("content"));
					bc.setBoardNo(rset.getInt("board_no"));
					bc.setCommentRef(rset.getInt("comment_ref"));
					bc.setRegDate(rset.getDate("reg_date"));
					comments.add(bc);
				}
			}
		} catch (SQLException e) {
			throw new BoardException("댓글목록 조회 오류 !",e);
			
		}
		return comments;
	}

	public int insertBoardComment(Connection conn, BoardComment bc) {
		String sql =prop.getProperty("insertBoardComment");
		int result = 0;
		Object ref = bc.getCommentRef()==0 ?   null : bc.getCommentRef(); // 0 값 처리 
		
		System.out.println("REF 확인넘버  = "+ref);
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, bc.getCommentLevel());
			pstmt.setString (2, bc.getWriter());
			pstmt.setString(3, bc.getContent());
			pstmt.setInt(4,bc.getBoardNo());
			pstmt.setObject(5, ref);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new BoardException("댓글등록  오류 !",e);
		}
		
		return result;
	}

	public int boardCommentDelete(Connection conn, int no) {
		String sql = prop.getProperty("boardCommentDelete");
		int result =0;
		//
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			throw new BoardException("댓글 삭제 오류 !",e);
			
		}
		return result;
	}

}

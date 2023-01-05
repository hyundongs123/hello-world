package com.sh.mvc.member.model.dao;
import static com.sh.mvc.common.JdbcTemplate.close;

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

import com.sh.mvc.member.model.dto.Gender;
import com.sh.mvc.member.model.dto.Member;
import com.sh.mvc.member.model.dto.MemberRole;
import com.sh.mvc.member.model.exception.MemberException;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		String path = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
		try{
			prop.load(new FileReader(path));
				
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("query load 완료" +prop);
		
	}
	
	/**
	 * 한건조회 존재하면 dto객체 반환 , 존재하지않으면 null 반환
	 * 여러건조회 존재하면 List<T> 반환 , 존재하지 않으면 비어있는 List<T>  반환 
	 * 
	 * 
	 * @param conn
	 * @param memberId
	 * @return
	 */

	public Member selectOneMember(Connection conn, String memberId) {
		Member member = null;
		String sql = prop.getProperty("selectOneMember");
	
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, memberId);
			
			try(ResultSet rset = pstmt.executeQuery()){
				
				while(rset.next()) {
					 member = handleMemberResultSet(rset);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}

	public int insertMember(Connection conn, Member member) {
		PreparedStatement  pstmt = null;
		String sql = prop.getProperty("insertMember");  //insertMember = insert into member values(?,?,?,default,?,?,?,?,?,default,default)
		int result = 0;
		try {
			 pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getGender().name());
			pstmt.setDate(5, member.getBirthday());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getPhone());
			pstmt.setString(8, member.getHobby());
			
			//2.실행 ->int
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			throw new MemberException("회원가입 오류",e);
		}finally{
			close(pstmt);
		}
		return result;
	}

	public int updateMember(Connection conn, Member member) {
		PreparedStatement pstmt =null;
		String sql = prop.getProperty("updateMember");
//		update member set member_name = ? ,birthday = ? ,email = ? , phone = ? ,point = ? ,gender = ?, hobby = ? where member_id = ?
		int result= 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberName());
			pstmt.setDate(2, member.getBirthday());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getPhone());
			pstmt.setInt(5, member.getPoint());
			pstmt.setString(6, member.getGender().name());
			pstmt.setString(7, member.getHobby());
			pstmt.setString(8, member.getMemberId());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			throw new MemberException("내정보 업데이트 오류",e);
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int memberUpdatePassword(Connection conn, String memberId, String newPassword) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePassword");
		int result = 0;
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setString(2, memberId);
			result =pstmt.executeUpdate();
			
		}catch(SQLException e ) {
			e.printStackTrace();
			throw new MemberException ("비밀번호 업데이트 오류",e);
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<Member> selectAllMember(Connection conn, Map<String, Object> param) {
		String sql = prop.getProperty("selectAllMember");
//		selectAllMember =select * from( select row_number() over(order by enroll_date desc) rnum, m.* from  member m) where rnum between ? and ?
		List<Member>members = new ArrayList<>();
		int page = (int)param.get("page");
		int limit = (int)param.get("limit");
		int start = (page-1) * limit +1;
		int end = page*limit;
		
		
		try (
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			try( ResultSet rset = pstmt.executeQuery()){
				while(rset.next()) {
					Member member = handleMemberResultSet(rset);
					members.add(member);
					}
			}
			
		
			
		} catch (SQLException e) {
			throw new MemberException("관리자 회원목록조회 오류! ",e);
		}
		

		
		return members;
	}

	private Member handleMemberResultSet(ResultSet rset) throws SQLException {
		Member member = new Member();
		member.setMemberId(rset.getString("member_id"));
		member.setPassword(rset.getString("password"));
		member.setMemberName(rset.getString("member_name"));
		member.setMemberRole(MemberRole.valueOf(rset.getString("member_role")));
		member.setGender(rset.getString("gender")!=null ? 
				Gender.valueOf(rset.getString("gender")) : 
					null);
		member.setBirthday(rset.getDate("birthday"));
		member.setEmail(rset.getString("email"));
		member.setPhone(rset.getString("phone"));
		member.setHobby(rset.getString("hobby"));
		member.setPoint(rset.getInt("point"));
		member.setEnrollDate(rset.getTimestamp("enroll_date"));
		return member;
	}

	public int updateMemberRole(Connection conn, String memberId, String memberRole) {
		int result = 0;
		String sql = prop.getProperty("updateMemberRole");
		PreparedStatement pstmt =null;
		// update member set member_role = ? where member_id = ?
		try {
			pstmt  =conn.prepareStatement(sql);
			pstmt.setString(1, memberRole);
			pstmt.setString(2, memberId);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new MemberException ("권한업데이트 오류 ",e);
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int delteMember(Connection conn, String memberId) {
		int result =0 ;
		String sql = prop.getProperty("deleteMember");
		PreparedStatement pstmt =null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			result =pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new MemberException("회원삭제에 실패하셨습니다.",e);
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<Member> searchMember(Connection conn, Map<String, String> param) {
		String sql = prop.getProperty("searchMember"); //select * from member where # like ?
		String searchType = param.get("searchType");   //member id member name gender
		String searchKeyword = param.get("searchKeyword");
		sql = sql.replace("#",searchType);
		System.out.println(sql);
		List<Member>members = new ArrayList<>();
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, "%"+searchKeyword+"%");
			
			try(ResultSet rset = pstmt.executeQuery()){
				while(rset.next()) {
					Member member = handleMemberResultSet(rset);
					members.add(member);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new MemberException("관리자회원검색 오류 ",e);
		}
		
		return members;
	}
	
	public int selectTotalCount(Connection conn) {
		String sql = prop.getProperty("selectTotalCount");
		
		int totalCount = 0;
		
		try(
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rset =pstmt.executeQuery();
			){
			while(rset.next()) {
			totalCount =rset.getInt(1); //컬럼인덱스
			}
			
		} catch (SQLException e) {
			throw new MemberException ("전체 사용자수 조회 오류",e);
		}
		
		return totalCount;
	}

	
	
	
	
	
	
	
	
	
	
}

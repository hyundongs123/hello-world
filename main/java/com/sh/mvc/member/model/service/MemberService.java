package com.sh.mvc.member.model.service;

import static com.sh.mvc.common.JdbcTemplate.close;
import static com.sh.mvc.common.JdbcTemplate.commit;
import static com.sh.mvc.common.JdbcTemplate.getConnection;
import static com.sh.mvc.common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.sh.mvc.member.model.dao.MemberDao;
import com.sh.mvc.member.model.dto.Member;

public class MemberService {

	private MemberDao memberDao = new MemberDao();
	
	public Member selectOneMember(String memberId) {
		
		
		//1. Connection 생성
		
		//2. DAO 요청 (Connection전달)
		Connection conn = getConnection();
		Member	member = memberDao.selectOneMember(conn,memberId);
		//3. Connection 반환
		close(conn);
		return member;
	}

	public int insertMember(Member member) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = memberDao.insertMember(conn,member);
			commit(conn);
		}catch(Exception e) {
			rollback(conn);
			throw e;
		}finally {
			close(conn);
		}
		return result;
	}

	public int updateMember(Member member) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = memberDao.updateMember(conn,member);
			commit(conn);
		}catch(Exception e) {
			rollback(conn);
			throw e;
		}finally {
			close(conn);
		}
		return result;
	}

	public int memberUpdatePassword(String memberId, String newPassword) {
		int result = 0;
		Connection conn = getConnection();
		
		try{
			result = memberDao.memberUpdatePassword(conn,memberId,newPassword);
			commit(conn);
		}catch(Exception e) {
			rollback(conn);
		}finally{
			close(conn);
		}
		return result;
	}

	public List<Member> selectAllMember(Map<String, Object> param) {

		Connection conn = getConnection();
		List<Member>members = memberDao.selectAllMember(conn,param);
		close(conn);
		return members;
	}

	public int updateMemberRole(String memberId, String memberRole) {
		int result = 0 ;
		
		Connection conn =getConnection();
		try {
			result = memberDao.updateMemberRole(conn,memberId,memberRole);
			commit(conn);
		}catch(Exception e) {
			rollback(conn);
		}finally{
			close(conn);
		}
		return result;
	}

	public int delteMember(String memberId) {
		int result =0 ;
		Connection conn =getConnection();
		
		try {
			result = memberDao.delteMember(conn,memberId);
			commit(conn);
		}catch(Exception e) {
			rollback(conn);
		}finally {
			close(conn);
		}
		
		
		return result;
	}

	public List<Member> serachMember(Map<String, String> param) {
		Connection conn =getConnection();
		List<Member> members = memberDao.searchMember(conn,param);
		close(conn);
		
		
		return members;
	}

	public int selectTotalCount() {
		Connection conn =getConnection();
		int totalCount = memberDao.selectTotalCount(conn);
		
		return totalCount;
	}


}

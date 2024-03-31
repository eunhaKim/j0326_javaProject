package mall;

import java.sql.SQLException;
import java.util.Vector;

public class MemberDao extends DBConn{
	MemberVo mvo = null;
	
	// 회원 전체 조회
	public Vector getMemberList() {
		Vector vData = new Vector<>();
		
		try {
			sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("pic"));
				vo.add(rs.getString("id"));
				vo.add(rs.getString("pwd"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("tel"));
				vo.add(rs.getString("addr"));
				vo.add(rs.getString("joinDate").substring(0,11));
				vo.add(rs.getInt("point"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL오류: " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vData;
	}
	
	// 조건을 이용한 다양한 검색처리
	public Vector getConditionSearch(String fieldName, String txtCondi) {
		Vector vData = new Vector<>();
		try {
			sql = "select * from member where "+fieldName+" like ? order by name";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+txtCondi+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("pic"));
				vo.add(rs.getString("id"));
				vo.add(rs.getString("pwd"));
				vo.add(rs.getString("name"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("tel"));
				vo.add(rs.getString("addr"));
				vo.add(rs.getString("joinDate").substring(0,11));
				vo.add(rs.getInt("point"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

	public int setDeleteMember(int idx) {
		int res=0;
		try {
			sql = "delete from member where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public MemberVo getIdSearch(String id) {
		MemberVo vo = new MemberVo();
		try {
			sql = "select * from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setPic(rs.getString("pic"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setGender(rs.getString("gender"));
				vo.setTel(rs.getString("tel"));
				vo.setAddr(rs.getString("addr"));
				vo.setJoinDate(rs.getString("joinDate"));
				vo.setPoint(rs.getInt("point"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	// 회원가입
	public int setMemberInput(MemberVo vo) {
		int res=0;
		try {
			sql="insert into member values (default, ?, ?, ?, ?, ?, ?, ?, default, default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPic());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getName());
			pstmt.setString(5, vo.getGender());
			pstmt.setString(6, vo.getTel());
			pstmt.setString(7, vo.getAddr());
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	public int setMemberUpdate(MemberVo vo) {
		int res=0;
		try {
//			System.out.println(vo);
			sql="update member set pwd = ? , name = ?, gender = ? , tel = ? , addr = ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getAddr());
			pstmt.setString(6, vo.getId());
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

	public String getAdminPwd() {
		String pwd = "";
		try {
			sql = "select * from member where id = 'admin'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) pwd = rs.getString("pwd");
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return pwd;
	}
}

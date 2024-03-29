package mall;

import java.sql.SQLException;
import java.util.Vector;

public class MallDao extends DBConn{
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
}

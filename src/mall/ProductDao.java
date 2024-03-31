package mall;

import java.sql.SQLException;
import java.util.Vector;

public class ProductDao extends DBConn{
	MemberVo mvo = null;
	
	// 상품 전체 조회
	public Vector getProductList() {
		Vector vData = new Vector<>();
		
		try {
			sql = "select * from product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("pIdx"));
				vo.add(rs.getString("pPic"));
				vo.add(rs.getString("pName"));
				vo.add(rs.getInt("pCnt"));
				vo.add(rs.getInt("pPrice"));
				vo.add(rs.getString("pInfo"));
				
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
			sql = "select * from product where "+fieldName+" like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+txtCondi+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("pIdx"));
				vo.add(rs.getString("pPic"));
				vo.add(rs.getString("pName"));
				vo.add(rs.getInt("pCnt"));
				vo.add(rs.getInt("pPrice"));
				vo.add(rs.getString("pInfo"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	
	// 삭제
	public int setDeleteProduct(int idx) {
		int res=0;
		try {
			sql = "delete from product where pIdx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	// 상품명 중복처리
	public ProductVo getPNameSearch(String pName) {
		ProductVo vo = new ProductVo();
		try {
			sql = "select * from product where pName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setpIdx(rs.getInt("pIdx"));
				vo.setpPic(rs.getString("pPic"));
				vo.setpName(rs.getString("pName"));
				vo.setpCnt(rs.getInt("pCnt"));
				vo.setpPrice(rs.getInt("pPrice"));
				vo.setpInfo(rs.getString("pInfo"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	// 상품등록
	public int setProductInput(ProductVo vo) {
		int res=0;
		try {
			sql="insert into product values (default, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getpPic());
			pstmt.setString(2, vo.getpName());
			pstmt.setInt(3, vo.getpCnt());
			pstmt.setInt(4, vo.getpPrice());
			pstmt.setString(5, vo.getpInfo());
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}
	// 상품정보 수정
	public int setProductUpdate(ProductVo vo) {
		int res=0;
		try {
//			System.out.println(vo);
			sql="update product set pPic = ?, pName = ?, pCnt = ?, pPrice = ?, pInfo = ?  where PIdx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getpPic());
			pstmt.setString(2, vo.getpName());
			pstmt.setInt(3, vo.getpCnt());
			pstmt.setInt(4, vo.getpPrice());
			pstmt.setString(5, vo.getpInfo());
			pstmt.setInt(6, vo.getpIdx());
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}
}

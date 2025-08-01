package menus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Dao : Data Access Object 여기서 모든 DB 조작
// CRUD 작업 : Create(Insert), Read(Select), Update(Update), Delete(Delete)
public class MenuDao {
	// 데이터 추가
	public void addMenu( String menu_id, String menu_name, int menu_seq ) {
		DBConn     db           = new DBConn();
		Connection conn         = db.getConnection();
		String sql = "";
		sql       += "INSERT INTO MENUS VALUES ( ?, ?, ? ) ";
		PreparedStatement pstmt = null;
		try {
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, menu_id);
			 pstmt.setString(2, menu_name);
			 pstmt.setInt(3, menu_seq);
			 
			 pstmt.executeUpdate();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	// 데이터 조회(전체목록)
	public ArrayList<MenuDto> getMenuList() {
		DBConn            db    = new DBConn();
		Connection        conn  = db.getConnection(); 
		
		String            sql   = "";
		sql += "SELECT * FROM MENUS ";
		sql += " ORDER BY MENU_SEQ ASC";
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		
		ArrayList<MenuDto> menuList = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);			
	        rs = pstmt.executeQuery();	// 조회	
	        
	        while( rs.next() ) {
	        	String  menu_id   = rs.getString("menu_id");
	        	String  menu_name = rs.getString("menu_name");
	        	int     menu_seq  = rs.getInt("menu_seq");
	        	
	        	MenuDto menuDto   = new MenuDto();
	        	
	        	menuDto.setMenu_id( menu_id );
	        	menuDto.setMenu_name( menu_name );
	        	menuDto.setMenu_seq( menu_seq );
	        	
	        	menuList.add( menuDto );
	        }
	        
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				
			}
		}
		return menuList;
	}
	
	// 데이터 조회(메뉴 한개)
	public MenuDto getMenu(String menu_id) { //이미 menu_id 변수를 만든거
		DBConn            db    = new DBConn();
		Connection        conn  = db.getConnection(); 
		
		String            sql   = "";
		sql += "SELECT * FROM MENUS ";
		sql += " WHERE MENU_ID = ?";
		PreparedStatement pstmt = null;
		ResultSet         rs = null;
		MenuDto dto = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu_id);
			rs    = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new MenuDto();
				dto.setMenu_name(rs.getString("menu_name"));
				dto.setMenu_seq(rs.getInt("menu_seq"));
			}
			
		} catch (SQLException e) {			
			
		} finally {
			try {
				if(rs != null) rs.close(); // null 이면 close(); 안함
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				
			}
		}
		
		return dto;        	
	}
	// 데이터 수정
	public void updateMenu(String menu_id, String menu_name, int menu_seq ) {
		DBConn     db           = new DBConn();
		Connection conn         = db.getConnection();
		String sql = "";
		sql       += "UPDATE MENUS ";
		sql       += " SET MENU_NAME = ?, MENU_SEQ = ? ";
		sql       += " WHERE MENU_ID = ?";
		PreparedStatement pstmt = null;
		try {
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, menu_name);
			 pstmt.setInt(2, menu_seq);
			 pstmt.setString(3, menu_id);
			 
			 pstmt.executeUpdate();
			 
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
		
	// 데이터 삭제
	public void delMenu(String menu_id) {
		DBConn db = new DBConn();
		Connection conn = db.getConnection();
		
		String sql = "";
		sql       += "DELETE FROM MENUS ";
		sql       += " WHERE MENU_ID = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu_id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	// 복습 
	public void upDate (String menu_id, String menu_name, int menu_seq ) {
		DBConn db = new DBConn();
		Connection conn = db.getConnection();
		String sql = "";
		sql += "UPDATE MENUS ";
		sql += " SET MENU_NAME = ?, MENU_SEQ = ?";
		sql += " WHERE MENU_ID = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu_name);
			pstmt.setInt(1, menu_seq);
			pstmt.setString(1, menu_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
		
} // MenuDao end


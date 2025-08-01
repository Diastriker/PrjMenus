<%@page import="menus.MenuDao"%>
<%@page import="menus.MenuDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	
	MenuDao dao                 = new MenuDao();    // Dao 쓸준비
	ArrayList<MenuDto> menuList = dao.getMenuList();
	// 다시 여기에서 Dto 타입의 배열을 만든다
	// Dao의 arraylist 함수를 불러와서 리턴값을 다시 menuList 변수에 담는다
	
	String html = "";
 	for(int i=0; i<menuList.size(); i++ ) { 
		MenuDto menu = menuList.get(i); // menuList 의 매줄을 Dto 필드에 넣는다 
		html += "<tr>";
		html += "<td>" + menu.getMenu_id() + "</td>";
		html += "<td>" + menu.getMenu_name() + "</td>";
		html += "<td>" + menu.getMenu_seq() + "</td>";
		html += "<td><a href='delaction.jsp?menu_id="+ menu.getMenu_id() +"'>삭제</a></td>";
		html += "<td><a href='updatemenu.jsp?menu_id=" + menu.getMenu_id() + "'>수정</a></td>";
		html += "</tr>";
  }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>메뉴목록</h2>
	
	<table border="1" width="978" align="center">
		<tr>
			<td>Menu_id</td>
			<td>Menu_name</td>
			<td>Menu_seq</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="5" align="right">
				<a href="addmenu.jsp">메뉴추가</a>
			</td>
		</tr>
		
		<!-- 시작 -->
		<%= html %>
		<!-- 끝 -->
	</table>
</body>
</html>
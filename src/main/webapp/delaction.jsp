<%@page import="menus.MenuDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String menu_id = request.getParameter("menu_id");
	System.out.print(menu_id);

	MenuDao dao = new MenuDao();
	dao.delMenu( menu_id );
	
	String loc= "menulist.jsp";
	response.sendRedirect(loc);
%>
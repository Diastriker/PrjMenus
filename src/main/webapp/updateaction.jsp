<%@page import="menus.MenuDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MenuDao menuDao = new MenuDao(); 
	
	String menu_id = request.getParameter("menu_id");
	String menu_name = request.getParameter("menu_name");
	String menu_seq_in = request.getParameter("menu_seq");
	int menu_seq   = Integer.parseInt( menu_seq_in );
	
	System.out.println(menu_id);
	System.out.println(menu_name);
	System.out.println(menu_seq);
	
	// updatemenu.jsp에서 받은 파라미터를 다시 db에 저장한다
	menuDao.updateMenu( menu_id, menu_name, menu_seq );
	
	// db에 저장하고 다시 전체메뉴 목록으로 돌아간다
	String loc = "menulist.jsp";
	response.sendRedirect(loc);
	
%>
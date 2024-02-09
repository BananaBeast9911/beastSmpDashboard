<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    // Invalidate the current session to log out the user
    HttpSession session = request.getSession(false);
    if (session != null) {
        session.invalidate();
    }
    // Redirect to the login page after logout
    response.sendRedirect("login.jsp");
%>
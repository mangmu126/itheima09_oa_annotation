<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   		<table>
   			<thead>
   				<tr>
   					<td>pid</td>
   					<td>name</td>
   					<td>修改</td>
   				</tr>
   			</thead>
   			<tbody>
   				<s:iterator value="#dataList">
   					<tr>
   						<td><s:property value="pid"/></td>
   						<td><s:property value="name"/></td>
   						<td><s:a action="personAction_updateUI?id=%{pid}">修改</s:a></td>
   					</tr>
   				</s:iterator>
   			</tbody>
   		</table>
  </body>
</html>

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<style type="text/css">

  </style>
</head>
<body>
<s:form action="execute" method="post" >
<h4>作者信息:</h4>
<table border="1">
<tbody>
<tr><td>作者编号: </td><td><s:property value="AuthorID"></s:property></td></tr>
<tr><td>姓名    : </td><td><s:property value="Name"></s:property></td></tr>
<tr><td>年龄    : </td><td><s:property value="Age"></s:property></td></tr>
<tr><td>国籍 : </td><td><s:property value="Country"></s:property></td></tr>
</tbody>
</table>
<h4>图书详情:</h4>
<table border="1">
<tbody>
<tr><td>ISBN       : </td><td><s:property value="ISBN"></s:property></td></tr>
<tr><td>书名      : </td><td><s:property value="Title"></s:property></td></tr>
<tr><td>作者编号   : </td><td><s:property value="AuthorID"></s:property></td></tr>
<tr><td>出版社  : </td><td><s:property value="Publisher"></s:property></td></tr>
<tr><td>出版日期: </td><td><s:property value="PublishDate"></s:property></td></tr>
<tr><td>价格    : </td><td><s:property value="Price"></s:property></td></tr>
</tbody>
</table>
</s:form>
</body>
</html>
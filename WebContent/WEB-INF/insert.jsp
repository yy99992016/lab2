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
插入：
<s:form action="insert" method="post">
     <s:textfield name="ISBN" label="ISBN："></s:textfield>
      <s:textfield name="Title" label="书名："></s:textfield>
      <s:textfield name="AuthorID" label="作者编号："></s:textfield>
        <s:textfield name="Publisher" label="出版社："></s:textfield>
         <s:textfield name="PublishDate" label="出版日期："></s:textfield>
          <s:textfield name="Price" label="价格："></s:textfield>
     <s:submit value="插入"></s:submit>
 </s:form>
</body>
</html>
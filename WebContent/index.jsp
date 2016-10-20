<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Library</title>
<style type="text/css">
  </style>
</head>
<body>
<form action="" name="forml">
<center>
<h1>于洋的萌萌哒小书屋</h1>
	<input type="button" value="查询" onclick="forml.action='jump1.action';forml.submit()"/>
	
	
	<input type="button" value="插入" onclick="forml.action='jump2.action';forml.submit()"/>
</center>
</form>
</body>
</html>
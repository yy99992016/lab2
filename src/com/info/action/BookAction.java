package com.info.action;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class BookAction implements Action {

	Connection connect=null;
	Statement state=null;
	Statement state1=null;
	ResultSet result=null;
	private String AuthorID;
	private String Name;
	private String Title;
	private String Country;
	private String Age;
	private String ISBN;
	private String Publisher;
	private String PublishDate;
	private String Price;
	public String isbn;
	public String title;
	public String publisher;
	public String publishdate;
	public String price;
	public ArrayList<String> AuthorList = new ArrayList<String>();
	public ArrayList<String> getBookList() {
		return BookList;
	}
	public void setBookList(ArrayList<String> bookList) {
		BookList = bookList;
	}
	private String authorid;
	ArrayList<String> BookList = new ArrayList<String>();
	public String getAuthorid() {
		return authorid;
	}
	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}
	public Connection getConnect() {
		return connect;
	}
	public void setConnect(Connection connect) {
		this.connect = connect;
	}
	public Statement getState() {
		return state;
	}
	public void setState(Statement state) {
		this.state = state;
	}
	public ResultSet getResult() {
		return result;
	}
	public void setResult(ResultSet result) {
		this.result = result;
	}
	public String getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(String authorID) {
		AuthorID = authorID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public ArrayList<String> getAuthorList() {
		return AuthorList;
	}
	public void setAuthorList(ArrayList<String> authorList) {
		AuthorList = authorList;
	}
	public String Query() throws Exception {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect=DriverManager.getConnection("jdbc:mysql://jwirpuzqobep.rds.sae.sina.com.cn:10196/yy?useUnicode=true&characterEncoding=utf-8&useSSL=false","yy","123123");
			state=connect.createStatement();
		}
		catch(Exception ex){}
		int i = 0,j=0;
		String sql = "select * from Author where Name = '"+getName()+"'";
		ResultSet res = state.executeQuery(sql);
		if(res.next()){
			ResultSet na = state.executeQuery("select * from Author where Name = '"+getName()+"'");
			ArrayList<String> num = new ArrayList<String>();
			while(na.next()){
				num.add(na.getString(1));
			}
			//System.out.print(num.get(1));
			for(j = 0;j < num.size();j++){
			String sql1 = "select * from Book where AuthorID=('" +num.get(j)+"' )";
			ResultSet res1 = state.executeQuery(sql1);
			while(res1.next()){
				BookList.add(res1.getString(2));
				i+=1;
			}
			}
			if(i == 0){
				return "NoBook";
			}
			else{
				ActionContext.getContext().put("li",BookList);
				return "Success";
			}
		}
		else{
			return "NoAuthor";
		}
	}
	/*public void BookList() throws Exception{
		setBookList(BookList);
		System.out.print(BookList.get(0));
		ActionContext.getContext().put("li",BookList);
	}*/
	public String execute() throws Exception {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect=DriverManager.getConnection("jdbc:mysql://jwirpuzqobep.rds.sae.sina.com.cn:10196/yy?useUnicode=true&characterEncoding=utf-8&useSSL=false","yy","123123");
			state=connect.createStatement();
		}
		catch(Exception ex){}
		//HttpServletRequest request = ServletActionContext.getRequest();
		//String title1 = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		//setTitle(ServletActionContext.getRequest().getParameter("Title"));
		String sql = "select * from Book where Title = '"+Title+"'";
		ResultSet res = state.executeQuery(sql);
		while(res.next()){
			setISBN(res.getString(1));
			setTitle(res.getString(2));
			setAuthorID(res.getString(3));
			setPublisher(res.getString(4));
			setPublishDate(res.getString(5));
			setPrice(res.getString(6));
		}
		//String sql1 = "select AuthorID from Book where Title = '"+getTitle()+"'";
		//ResultSet res1 = state.executeQuery(sql1);
		String sql2 = "select * from Author where AuthorID=(select AuthorID from Book where Title= '" +Title+"' )";
		ResultSet res2 = state.executeQuery(sql2);
		while(res2.next()){
			setAuthorID(res2.getString(1));
			setName(res2.getString(2));
			setAge(res2.getString(3));
			setCountry(res2.getString(4));
		}
		return "detail";
	}
	public String Delete() throws Exception,UnsupportedEncodingException, SQLException{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect=DriverManager.getConnection("jdbc:mysql://jwirpuzqobep.rds.sae.sina.com.cn:10196/yy?useUnicode=true&characterEncoding=utf-8&useSSL=false","yy","123123");
			state=connect.createStatement();
		}
		catch(Exception ex){}
		//HttpServletRequest request = ServletActionContext.getRequest();
		//String bookname = new String(request.getParameter("name"));
		String sql = "delete from Book where Title = '"+Title+"'";
		state.executeUpdate(sql);
		return "deletesuccess";
	}
	public String Insert() throws Exception{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect=DriverManager.getConnection("jdbc:mysql://jwirpuzqobep.rds.sae.sina.com.cn:10196/yy?useUnicode=true&characterEncoding=utf-8&useSSL=false","yy","123123");
			state=connect.createStatement();
		}
		catch(Exception ex){}
		String sql = "select * from Author where AuthorID = '"+getAuthorID()+"'";
		ResultSet res = state.executeQuery(sql);
		if(res.next()){
			String sql2 = "select * from Book where ISBN = '"+getISBN()+"'";
			ResultSet res2 = state.executeQuery(sql2);
			if(res2.next()){
				return "occupy";
			}
			else{
				String sql1 = "insert into Book values('"+getISBN()+"',"+"'"+getTitle()+"'"+",'"+getAuthorID()+"',"+"'"+getPublisher()+"'"+","+"'"+getPublishDate()+"'"+",'"+getPrice()+"')";
				state.executeUpdate(sql1);
				return "insertsuccess";
			}
		}
		else{
			isbn = getISBN();
			String sql2 = "select * from Book where ISBN = '"+isbn+"'";
			ResultSet res2 = state.executeQuery(sql2);
			if(!res2.next()){
				isbn = getISBN();
				title = getTitle();
				publisher = getPublisher();
				publishdate = getPublishDate();
				price = getPrice();
				return "insertauthor1";
			}
			else{
				return "occupy";
			}
		}
	}
	public String AuthorList()throws Exception{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect=DriverManager.getConnection("jdbc:mysql://jwirpuzqobep.rds.sae.sina.com.cn:10196/yy?useUnicode=true&characterEncoding=utf-8&useSSL=false","yy","123123");
			state=connect.createStatement();
			state1 = connect.createStatement();
		}
		catch(Exception ex){}
		String sql = "select * from Author where Name = 'gx'";
		ResultSet res = state.executeQuery(sql);
		if(res.next()){
			ResultSet res1 = state.executeQuery(sql);
			while(res1.next()){
				AuthorList.add(res1.getString(2));
			}
			ActionContext.getContext().put("li",AuthorList);
			return "authorlist";
		}
		else{
			return "noauthor";
		}
	}
	public String Update() throws Exception{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect=DriverManager.getConnection("jdbc:mysql://jwirpuzqobep.rds.sae.sina.com.cn:10196/yy?useUnicode=true&characterEncoding=utf-8&useSSL=false","yy","123123");
			state=connect.createStatement();
			state1 = connect.createStatement();
		}
		catch(Exception ex){}
		String sql = "select * from Author where Name = '"+getName()+"'";
		ResultSet res = state.executeQuery(sql);
		String sql0 = "select * from Book where Title = '"+getTitle()+"'";
		ResultSet res0 = state1.executeQuery(sql0);
		if(res0.next()){
		if(res.next()){
			String sql1 = "update Book set AuthorID='"+res.getString(1)+"' where Title='"+getTitle()+"'";
			state.executeUpdate(sql1);
			String sql2 = "update Book set Publisher='"+getPublisher()+"' where Title='"+getTitle()+"'";
			state.executeUpdate(sql2);
			String sql3 = "update Book set PublishDate='"+getPublishDate()+"' where Title='"+getTitle()+"'";
			state.executeUpdate(sql3);
			String sql4 = "update Book set Price='"+getPrice()+"' where Title='"+getTitle()+"'";
			state.executeUpdate(sql4);
			return "updatesuccess";
		}
		else{
			title = getTitle();
			publisher = getPublisher();
			publishdate = getPublishDate();
			price = getPrice();
			return "insertauthor";
		}
		}
		else{
			return "nobook";
		}
	}
	public String InsertAuthor() throws Exception{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect=DriverManager.getConnection("jdbc:mysql://jwirpuzqobep.rds.sae.sina.com.cn:10196/yy?useUnicode=true&characterEncoding=utf-8&useSSL=false","yy","123123");
			state=connect.createStatement();
		}
		catch(Exception ex){}
		String sql = "select * from Author where AuthorID = '"+getAuthorID()+"'";
		ResultSet res = state.executeQuery(sql);
		if(!res.next()){
			String sql0 = "insert into author values('"+getAuthorID()+"','"+getName()+"','"+getAge()+"','"+getCountry()+"')";
			state.executeUpdate(sql0);
			String sql1 = "update Book set AuthorID='"+getAuthorID()+"' where Title='"+title+"'";
			state.executeUpdate(sql1);
			String sql2 = "update Book set Publisher='"+publisher+"' where Title='"+title+"'";
			state.executeUpdate(sql2);
			String sql3 = "update Book set PublishDate='"+publishdate+"' where Title='"+title+"'";
			state.executeUpdate(sql3);
			String sql4 = "update Book set Price='"+price+"' where Title='"+title+"'";
			state.executeUpdate(sql4);
			return "insertauthorsuccess";
		}
		else{
			return "occupy";
		}
	}
	public String InsertAuthor1() throws Exception{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect=DriverManager.getConnection("jdbc:mysql://jwirpuzqobep.rds.sae.sina.com.cn:10196/yy?useUnicode=true&characterEncoding=utf-8&useSSL=false","yy","123123");
			state=connect.createStatement();
		}
		catch(Exception ex){}
		String sql = "select * from Author where AuthorID = '"+getAuthorID()+"'";
		ResultSet res = state.executeQuery(sql);
		if(!res.next()){
			String sql0 = "insert into Author values('"+getAuthorID()+"','"+getName()+"','"+getAge()+"','"+getCountry()+"')";
			state.executeUpdate(sql0);
			String sql1 = "insert into Book values('"+getISBN()+"',"+"'"+getTitle()+"'"+",'"+getAuthorID()+"',"+"'"+getPublisher()+"'"+","+"'"+getPublishDate()+"'"+",'"+getPrice()+"')";
			state.executeUpdate(sql1);
			return "insertauthor1success";
		}
		else{
			return "occupy";
		}
	}
	public String dir_query()
	{
		return "Success";
	}
	public String dir_insert()
	{
		return "Success";
	}
	public String dir_update()
	{
		return "Success";
	}
	public String Return(){
		return "Success";
	}
}

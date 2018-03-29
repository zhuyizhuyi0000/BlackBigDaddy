package com.sin;
import java.io.IOException;

import java.io.PrintWriter;

 

import javax.servlet.Servlet;

import javax.servlet.ServletConfig;

import javax.servlet.ServletException;

import javax.servlet.ServletRequest;

import javax.servlet.ServletResponse;

 

public class HelloWorld implements Servlet  {

 


public void destroy() {

System.out.println("destroy,hoho!");

 

}

 


public ServletConfig getServletConfig() {

// TODO Auto-generated method stub

return null;

}

 


public String getServletInfo() {

// TODO Auto-generated method stub

return null;

}



public void init(ServletConfig arg0) throws ServletException {

System.out.println("init it,ok");

 

}



public void service(ServletRequest reg, ServletResponse res)

throws ServletException, IOException {

// TODO: Add your code here

System.out.println("service it");

//从res中得到PrintWriter

PrintWriter pw = res.getWriter();

pw.println("hello,world,My first Eclipse Servlet!");

 

}

 

}
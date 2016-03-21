package com.hireme.shortenurl.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;
import javax.ws.rs.FormParam;

import org.apache.catalina.connector.Request;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hireme.shortenurl.VO.ErrorVO;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ErrorController extends Exception {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String customAlias;
	
    @ExceptionHandler(MySQLIntegrityConstraintViolationException.class)
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    @ResponseBody
	 public ErrorVO CustomFound() throws Exception{
    	String custom_alias="";
		 return new ErrorVO(custom_alias, "001", "CUSTOM ALIAS ALREADY EXISTS");
	 }
    

}

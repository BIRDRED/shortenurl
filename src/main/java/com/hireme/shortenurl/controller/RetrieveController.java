package com.hireme.shortenurl.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hireme.shortenurl.VO.ErrorVO;
import com.hireme.shortenurl.persistence.ShortenDAO;

@RestController
public class RetrieveController {
	 @RequestMapping("retrieve")
	 public ModelAndView shortenCreate(@RequestParam(value="CUSTOM_ALIAS") String customAlias,HttpServletResponse httpServletResponse) throws Exception {  
		 ShortenDAO sdao = new ShortenDAO();
		 String url = sdao.consulta(customAlias);
		 if(url == null){
			 return new ModelAndView("redirect:/ExceptionNull?CUSTOM_ALIAS=" + customAlias);
		 }
         return new ModelAndView("redirect:http://" + url);

	 }
	 

		@RequestMapping("ExceptionNull")
		 public ErrorVO ExceptionNull(@RequestParam(value="CUSTOM_ALIAS") String customAlias) throws Exception {  
			 return new ErrorVO(customAlias, "002", "SHORTENED URL NOT FOUND");
		 }
		 
	 
}

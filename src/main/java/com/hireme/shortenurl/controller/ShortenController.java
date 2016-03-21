package com.hireme.shortenurl.controller;

import java.util.zip.CRC32;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hireme.shortenurl.VO.shortenVO;
import com.hireme.shortenurl.persistence.ShortenDAO;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@RestController
public class ShortenController {
	
	Long initTime;
	
	 @PostConstruct
	 public void beforeshortenCreate(){
		 initTime = System.currentTimeMillis();
	 }
	 
	 @RequestMapping("create")
	 public shortenVO shortenCreate(@RequestParam(value="URL") String URL,@RequestParam(value="CUSTOM_ALIAS" , required=false) String customAlias) throws Exception {  
		 try{
			 ShortenDAO sdao= new ShortenDAO();
		 if(customAlias == null){	
			  CRC32 crc = new CRC32();
			  crc.update(URL.getBytes());
			  Long responseTime = System.currentTimeMillis() - initTime;
			  shortenVO svo = new shortenVO(URL, Long.toHexString(crc.getValue()));
			  sdao.cadastrar(svo);
			  return new shortenVO("http://shortenurl/u/"+Long.toHexString(crc.getValue()),Long.toHexString(crc.getValue()),responseTime); 	
	       }else{
	    	   Long responseTime = System.currentTimeMillis() - initTime;
			   sdao.cadastrar(new shortenVO(URL, customAlias));
	    	   return new shortenVO("http://shortenurl/u/"+customAlias, customAlias,responseTime); 
	       }
		 }catch(MySQLIntegrityConstraintViolationException e){
			 	throw new MySQLIntegrityConstraintViolationException(customAlias);
		 }
	 }
	 
	}

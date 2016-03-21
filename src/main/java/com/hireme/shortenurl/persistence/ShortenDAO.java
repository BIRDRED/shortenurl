package com.hireme.shortenurl.persistence;

import com.hireme.shortenurl.VO.shortenVO;


public class ShortenDAO extends DAO {

	public void cadastrar(shortenVO svo) throws Exception{
		open();
		stmt = con.prepareStatement("INSERT INTO shortenurl (CUSTOM_ALIAS,URL) VALUES (?,?)");
		stmt.setString(1, svo.getCustomAlias());
		stmt.setString(2, svo.getURL());
		stmt.execute();
		close();
	}
	
	public String consulta(String customAlias) throws Exception{
		open();
		stmt = con.prepareStatement("SELECT URL FROM shortenurl WHERE CUSTOM_ALIAS = ?");
		stmt.setString(1, customAlias);
		String url="";
		rs = stmt.executeQuery();

		if(rs.next()){
			url= rs.getString("URL");
		}else {
			url = null;
		}
		close();
		return url;
	}
}

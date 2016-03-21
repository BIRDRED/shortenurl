package com.hireme.shortenurl.VO;

public class shortenVO {

	
	String URL;
	String customAlias;
	Long timetaken;
	
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getCustomAlias() {
		return customAlias;
	}
	public void setCustomAlias(String customAlias) {
		this.customAlias = customAlias;
	}
	
	
	public Long getTimetaken() {
		return timetaken;
	}
	public void setTimetaken(Long timetaken) {
		this.timetaken = timetaken;
	}
	public shortenVO(String uRL, String customAlias) {
		super();
		URL = uRL;
		this.customAlias = customAlias;
	}
	
	
	public shortenVO(String uRL, String customAlias, Long timetaken) {
		super();
		URL = uRL;
		this.customAlias = customAlias;
		this.timetaken = timetaken;
	}
	public shortenVO() {
		super();
	}
	
	
	
	
}

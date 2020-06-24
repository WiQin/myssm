package com.wyw.spring.basic.ioc.annotation;

public class Office {
	private String num = "001";
	
	public Office(){
		
	}
	
	public Office(String num) {
		this.num = num;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
}

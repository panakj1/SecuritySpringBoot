package com.sepringsecurityresponseVo;

import java.util.List;

import com.sepringsecurity.model.MenuCard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class EmpResponseVo {
	
	private String text;
	private int size;
	private List<MenuCard> data;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<MenuCard> getData() {
		return data;
	}
	public void setData(List<MenuCard> data) {
		this.data = data;
	}
	

}

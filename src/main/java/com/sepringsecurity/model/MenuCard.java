package com.sepringsecurity.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//@Entity
//@Table(name="MenuCard")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class MenuCard {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.TABLE)
	//@Column(name="menu_id")
	private Long menuId;
	//@Column(name="menu_name")
	private String name;
	//@Column(name="menu_price")
	private double price;
	//@Column(name="menu_item")
	private String item;
	
	
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public MenuCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuCard(Long id,String name, double price, String item) {
		super();
		this.menuId=id;
		this.name = name;
		this.price = price;
		this.item = item;
	}
	@Override
	public String toString() {
		return "MenuCard [menuId=" + menuId + ", name=" + name + ", price=" + price + ", item=" + item + "]";
	}
	

}

package com.sepringsecurity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sepringsecurity.model.MenuCard;

@Service
public class MenuCardService {
	
	
	public List<MenuCard> getAllMenuCardDetails(){
		List<MenuCard> list=getList();		
		return list;
		
	}
	
	public MenuCard getMenuID(Long id) throws Exception {
		try {
		List<MenuCard> cardId=getList().stream().filter(a->a.getMenuId()==id).collect(Collectors.toList());
		return cardId.get(0);
		}catch(Exception e) {
			throw new Exception("Record not found");
		}
	}
	
	private List<MenuCard> getList(){
		List<MenuCard> list=new ArrayList<MenuCard>();
	list.add(new MenuCard(1L,"Rajma",101.00,"Rajma001"));
	list.add(new MenuCard(34L,"Chawal",50.00,"Chawal001"));
	list.add(new MenuCard(2L,"Daal_Fries",70.00,"DaalFries001"));
	list.add(new MenuCard(3L,"Daal_Makhani",100.00,"DaalMakhani001"));
	list.add(new MenuCard(11L,"Mix_Veg",60.00,"MixVeg60.4"));
	return list;
	}

}

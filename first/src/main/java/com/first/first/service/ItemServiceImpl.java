package com.first.first.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.first.first.model.Item;
import com.first.first.utility.Utility;

@Service
public class ItemServiceImpl implements ItemService{

	
	@Override
	public String addItem(Item item) {
		
		//Buisness logic 
		String msg=Utility.insertItem(item);
		return msg;
	}

	@Override
	public List<Item> getItems() {
		List<Item> itemList=Utility.getItems();
		return itemList;
	}

}

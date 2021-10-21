package com.first.first.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.first.first.model.Item;

public class Utility {

	public static Map<Long, Item> map=null;
	
	static {
		map=new HashMap();
	}
	
	public static String insertItem(Item item){
		
		long l=incrementId();
		item.setId(l);
		map.put(l,item);
		
		return "Record Inserted";
	}

	private static Long incrementId() {
		int id = 0;
		if(map.size()>0)
			id=(map.size()+1);
		else
			id=1;
		return (long) id;
	}

	public static List<Item> getItems() {
		
		List<Item> list=new ArrayList();
		
		for(Entry<Long, Item> e:map.entrySet())
			list.add(e.getValue());
		
		return list;
	}
}

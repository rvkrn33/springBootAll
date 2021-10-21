package com.first.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.first.first.model.Item;
import com.first.first.service.ItemService;

@RestController // @Controller + @ResponseBody
class ItemController{

	
	@Autowired
	ItemService itemService;
	
	
	//UI -> Controller -> service -> ServiceImpl -> utility (save)
	
	@PostMapping("/addItem") // @Post + RequestMapping("/addItem")  
	public ResponseEntity<String> addItem(@RequestBody Item item){
		
		//save data
		String msg=itemService.addItem(item);
		
		return new ResponseEntity(msg,HttpStatus.CREATED);
	}
	
	@GetMapping("/items")
	public ResponseEntity<List<Item>> getItems(){
		
		List<Item> list=itemService.getItems();
		
		return new ResponseEntity(list,HttpStatus.OK);
	}
	
	
}
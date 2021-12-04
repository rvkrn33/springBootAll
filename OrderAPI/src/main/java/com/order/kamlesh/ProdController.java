package com.order.kamlesh;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdController {

	
	public ResponseEntity<List<Product>> getProd(){
		
		List<Product> pList=new ArrayList<Product>();
		
		List<Images> imList=new ArrayList<Images>();
		Images i1=new Images("assets/images/products/keyboard/1-small.png",
				"assets/images/products/keyboard/1-medium.png",
				"assets/images/products/keyboard/1-big.png");
		
		Images i2=new Images("assets/images/products/keyboard/2-small.png",
				"assets/images/products/keyboard/2-medium.png",
				"assets/images/products/keyboard/2-big.png");
		
		Images i3=new Images("assets/images/products/keyboard/3-small.png",
				"assets/images/products/keyboard/3-medium.png",
				"assets/images/products/keyboard/3-big.png");
		
		imList.add(i1);  imList.add(i2); imList.add(i3);
		
		Product p1=new Product(2, "ravi", 44, 55, 88,50,66,"descrip", 33, 44, "red", "66",30
				, 4552, imList);
		
		pList.add(p1);
		
		return new ResponseEntity(pList, HttpStatus.OK);
	}
}

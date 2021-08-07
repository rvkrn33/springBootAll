package com.order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
public class OrderController {

	 @Autowired
	    private EurekaClient eurekaClient;
	
	 
	List<Order> list=null;
	
	@GetMapping("/orders")
	public List<Order> getAllOrder(){
		
		List<Order> list = prepareOrder();
		
		return list;
	}

	
	@GetMapping("/order/{id}/{quantity}")
	public String updateProd(@PathVariable int id, @PathVariable int quantity){
		//need to call proct service
		
		RestTemplate restTemplate=new RestTemplate();
		
		ResponseEntity<String> res=restTemplate.getForEntity("http://localhost:9092/product/{"+id+"}/{"+quantity+"}", String.class);
		String result=res.getBody();
		
		  System.out.println("Regular :" + result);
		 Application application = eurekaClient.getApplication("product-service");
		 
	     InstanceInfo instanceInfo = application.getInstances().get(0);
	        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "product/{"+id+"}+/{"+quantity+"}";
	        System.out.println("URL" + url);
	        
	        ResponseEntity<String> res1=restTemplate.getForEntity(url, String.class);
			String result1=res1.getBody();
			
	        System.out.println("Discovery client " + result1);
	        
		
		return result;
	}
	
	private List<Order> prepareOrder() {
		List<Order> list=new ArrayList();
		list.add(new Order(1, 12,"abc"));
		list.add(new Order(15, 55,"afffbc"));
		list.add(new Order(16, 20,"hhhh"));
		return list;
	}
	
	
}



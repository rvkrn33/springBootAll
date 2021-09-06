/**
 * 
 */
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

/**
 * @author RAVIKIRAN
 *
 */
//@Component
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository custRepository;
	
	@Override
	public String saveCustData(Customer cust) {
		custRepository.save(cust); // insert into the database
		return "Saved";
	}

	@Override
	public List<Customer> getCustomerList() {
		System.out.println("Execute ");
		return custRepository.findAll();
	}

	@Override
	public Customer getCustomer(long id) {
		
		Optional<Customer> op=custRepository.findById(id);
		
		if(op.isPresent()) {
			{
				System.out.println("Data is found ->"+op.get());
				return op.get();
			}
		}else
		{
			System.out.println("Data is not found ");
			return null;
		}
		
		//return custRepository.getById(id);
	}

	@Override
	public String updateCustData(Customer cust) {
		custRepository.save(cust); // insert into the database
		return "Updated";
	}

	@Override
	public String deleteCustomer(long id) {
		custRepository.deleteById(id);
		return "Deleted";
	}

	@Override
	public String customUpdateCustData(Customer cust) {
		
		List<Customer> list=custRepository.findByName(cust.getName());
		if(list.size()>0) {
			
			for(Customer c:list) {
				c.setAddress("Nashik");
				custRepository.save(c);
			}
		}
		return "All updated";
	}

}

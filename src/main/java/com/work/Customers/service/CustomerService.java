package com.work.Customers.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.work.Customers.model.Customer;
import com.work.Customers.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
	
	private CustomerRepository repo;
	
	public List<Customer> getAll(){
		return repo.findAll();
	}
	
	public Customer getOne(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
	}
	
	public Customer create(Customer cus) {
		return repo.save(cus);
	}
	public Customer update(Long id, Customer cus) {
		return repo.findById(id).map((c) -> {
			c.setName(cus.getName());
			c.setEmail(cus.getEmail());
			c.setOrderDish(cus.getOrderDish());
			
			return repo.save(c);
		}).orElseThrow(() -> new RuntimeException("Not Found"));
	
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
}
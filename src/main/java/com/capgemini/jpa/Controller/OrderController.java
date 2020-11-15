package com.capgemini.jpa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.jpa.Repository.CustomerRepository;
import com.capgemini.jpa.Repository.ProductRepository;
import com.capgemini.jpa.dto.OrderRequest;
import com.capgemini.jpa.dto.OrderResponse;
import com.capgemini.jpa.entities.Customer;

@RestController
public class OrderController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;
	
	
	@PostMapping("/placeOrder")
	public Customer placeOrder(@RequestBody OrderRequest request) {
		return customerRepository.save(request.getCustomer());
	}
	
	@GetMapping("/findAllOrders")
	public List<Customer> findAllOrders(){
		return customerRepository.findAll();
	}
	
	@GetMapping("/getInfo")
	public List<OrderResponse> getJoinInformation(){
		return customerRepository.getJoinInformations();
	}
	
	
	

}

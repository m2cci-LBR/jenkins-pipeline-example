package com.capgemini.jpa.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.jpa.dto.OrderResponse;
import com.capgemini.jpa.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
	@Query("SELECT new com.capgemini.jpa.dto.OrderResponse (c.name ,p.productName) FROM Customer c JOIN c.products p")
	public List<OrderResponse> getJoinInformations();
	
	@Query("SELECT c FROM Customer c where c.name = ?1 AND c.gender = ?2")
	public List<Customer> findByNameAndGender(String name,String gender);
	
	@Query("FROM Customer WHERE name = ?1 ORDER BY email ASC")
	public List<Customer> findByNameOrderByEmail(String name);
	
	@Query("FROM Customer WHERE name = ?1")
	public List<Customer> findByName1(String name,Sort sort);
	
	@Query("FROM Customer WHERE name = ?1")
	public List<Customer> findByName2(String name,Pageable pageable);
	
	
	@Query("FROM #{#entityName} WHERE name = ?1")
	public List<Customer> findByName3(String name,Sort sort);
	
	
	
	

}

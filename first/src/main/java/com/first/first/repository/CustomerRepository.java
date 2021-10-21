package com.first.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.first.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}

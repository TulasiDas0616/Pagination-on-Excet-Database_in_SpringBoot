package com.ssd.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssd.blog.entity.Customer;
@Repository
public interface CustomerRepository  extends JpaRepository<Customer, String> {
}

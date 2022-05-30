package com.claudionogueira.logisticsproject.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claudionogueira.logisticsproject.domain.models.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

	Optional<Customer> findByEmail(String email);
}

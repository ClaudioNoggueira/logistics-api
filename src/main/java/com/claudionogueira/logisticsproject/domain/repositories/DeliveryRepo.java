package com.claudionogueira.logisticsproject.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claudionogueira.logisticsproject.domain.models.Delivery;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery, Long> {

}

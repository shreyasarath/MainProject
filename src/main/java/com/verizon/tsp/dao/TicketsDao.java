package com.verizon.tsp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.tsp.models.Tickets;

@Repository
public interface TicketsDao extends JpaRepository<Tickets, Long>{

}

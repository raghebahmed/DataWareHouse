package com.example.ClusteredData.Warehouse;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ClusteredData.Warehouse.entites.Order;

public interface Repository extends JpaRepository<Order, Long>{

}

package org.example.Interview.repo;

import org.example.Interview.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findOrdersByUser_Id(Integer userId);
}
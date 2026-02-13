package org.example.Interview.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.Interview.entity.Orders;
import org.example.Interview.entity.User;
import org.example.Interview.repo.OrderRepository;
import org.example.Interview.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControllerService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    public ControllerService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(String name, Integer age) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Error, name not found");
        }
        if(age == null || age < 0) {
            throw new IllegalArgumentException("Error, age not found");
        }
        if(userRepository.existsUserByName(name)) {
            throw new IllegalArgumentException("Error, name duplicated!");
        }
        User user = new User(name, age);
        userRepository.save(user);
    }
    @Transactional
    public void saveOrders(Integer id, String itemName) {
        if(id == null) throw new IllegalArgumentException("Error, not found");
        if(itemName == null || itemName.isBlank()) {
            throw new IllegalArgumentException("Error, item not found");
        }
        User user = userRepository.findUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Error, id not found"));
        Orders orders = new Orders(itemName, user);
        orderRepository.save(orders);
    }
    @Transactional
    public List<String> getAllItems (Integer id) {
        if(id == null) throw new IllegalArgumentException("Error, id not found");
        List<Orders> orders = orderRepository.findOrdersByUser_Id(id);
        return orders.stream().map(Orders::getItemName).toList();
    }
    @Transactional
    public void deleteItem(Integer id) {
        if(id == null) throw new IllegalArgumentException("Error, id not found");
        List<Orders> orders = orderRepository.findOrdersByUser_Id(id);
        if(!orders.isEmpty()) {
            Orders orders1 = orders.get(orders.size() - 1);
            orderRepository.delete(orders1);
        }
    }
}
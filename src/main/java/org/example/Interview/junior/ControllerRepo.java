package org.example.Interview.junior;

import org.example.Interview.dto.OrdersDTO;
import org.example.Interview.dto.UserDTO;
import org.example.Interview.service.ControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerRepo {
    private final ControllerService controllerService;
    public ControllerRepo(ControllerService controllerService) {
        this.controllerService = controllerService;
    }

    @PostMapping("/create_user")
    public ResponseEntity<String> responseEntity(@RequestParam String name, @RequestParam Integer age) {
        controllerService.saveUser(name, age);
        return ResponseEntity.ok("User created base!");
    }
    @PostMapping("/create_orders")
    public ResponseEntity<String> responseOrders(@RequestParam Integer id, @RequestParam String item) {
        controllerService.saveOrders(id, item);
        return ResponseEntity.ok("Item created base!");
    }
    @GetMapping("/get_items")
    public ResponseEntity<List<String>> getAllItemsResponse(@RequestParam Integer id) {
        return ResponseEntity.ok(controllerService.getAllItems(id));
    }
    @DeleteMapping("/delete_item")
    public ResponseEntity<String> itemDeleteResponse(@RequestParam Integer id) {
        controllerService.deleteItem(id);
        return ResponseEntity.ok("Item delete successful!");
    }
}
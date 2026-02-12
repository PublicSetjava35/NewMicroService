package org.example.Interview.respect;
import org.example.Interview.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {
    private final ControllerService controllerService;
    public TestController(ControllerService controllerService) {
        this.controllerService = controllerService;
    }
    @PostMapping("/create_user")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) {
        controllerService.saveUser(userDTO.getEmail(), userDTO.getPassword());
        return ResponseEntity.ok("Вы были успешно зарегистрированы!");
    }
    @PostMapping("/create_item")
    public ResponseEntity<?> createResources(@RequestParam String item, @RequestParam Integer id) {
        controllerService.saveListItems(id, item);
        return ResponseEntity.ok("Ваш предмет успешно добавлен!");
    }
    @GetMapping("/get_item")
    public ResponseEntity<List<String>> listItems(@RequestParam Integer id) {
        return ResponseEntity.ok(controllerService.getListItems(id));
    }
}
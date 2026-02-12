package org.example.Interview.respect;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.Interview.db.Resources;
import org.example.Interview.db.User;
import org.example.Interview.repositories.ResourcesRepository;
import org.example.Interview.repositories.UserRepository;
import org.example.Interview.security.ClassSecurity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ControllerService {

    private final UserRepository userRepository;
    private final ResourcesRepository resourcesRepository;
    private final ClassSecurity classSecurity;
    public ControllerService(UserRepository userRepository, ResourcesRepository resourcesRepository, ClassSecurity classSecurity) {
        this.userRepository = userRepository;
        this.resourcesRepository = resourcesRepository;
        this.classSecurity = classSecurity;
    }
    @Transactional
    public void saveUser(String email, String password) {
        if(email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Ошибка, email пуст!");
        }
        if(password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Ошибка, пароль пуст!");
        }
        if(userRepository.existsByEmail(email)) {
            throw new EntityNotFoundException("Email, already exist");
        }
        String hashed = classSecurity.passwordEncoder().encode(password);
        userRepository.save(new User(email, hashed, localDateTime()));
    }
    @Transactional
    public void saveListItems(Integer id, String items) {
        if(items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Ошибка, ресурсы не найдены!");
        }
        if(id == null) {
            throw new IllegalArgumentException("Error, id not found");
        }
        User user = userRepository.findUserById(id).orElseThrow(() -> new RuntimeException("User, not found"));
        Resources resources = new Resources(items);
        resources.setUser(user);
        resourcesRepository.save(resources);
    }
    @Transactional
    public List<String> getListItems(Integer id) {
        List<Resources> resources = resourcesRepository.findByUser_Id(id);
        return resources.stream().map(Resources::getItems).toList();
    }
    public LocalDateTime localDateTime() {
        return LocalDateTime.now();
    }
}
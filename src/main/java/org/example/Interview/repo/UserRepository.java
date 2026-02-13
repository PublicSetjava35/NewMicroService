package org.example.Interview.repo;

import org.example.Interview.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserReposiory extends JpaRepository<User, Integer> {
    Optional<User> findUserById(Integer id);
    boolean findUserByName(String name);
}

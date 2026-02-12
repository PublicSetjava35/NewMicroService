package org.example.Interview.repositories;
import org.example.Interview.db.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResourcesRepository extends JpaRepository<Resources, Integer> {
    List<Resources> findByUser_Id(Integer userId);
}
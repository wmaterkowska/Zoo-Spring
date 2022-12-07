package com.github.weronika.zoo.db.repo;

import com.github.weronika.zoo.db.model.Animal;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{
}

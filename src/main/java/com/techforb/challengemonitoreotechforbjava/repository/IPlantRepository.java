package com.techforb.challengemonitoreotechforbjava.repository;

import com.techforb.challengemonitoreotechforbjava.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlantRepository extends JpaRepository<Plant, String> { }

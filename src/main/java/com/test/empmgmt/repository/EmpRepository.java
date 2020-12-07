package com.test.empmgmt.repository;

import com.test.empmgmt.model.Empl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Empl, Long> {
    
}

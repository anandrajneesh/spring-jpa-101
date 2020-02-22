package com.gluecoders.databasesqlexample.basics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

    public Employee findByFirstName(String firstName);
}

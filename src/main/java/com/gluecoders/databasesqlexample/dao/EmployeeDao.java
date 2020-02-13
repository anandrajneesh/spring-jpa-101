package com.gluecoders.databasesqlexample.dao;

import com.gluecoders.databasesqlexample.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

    public Employee findByFirstName(String firstName);
}

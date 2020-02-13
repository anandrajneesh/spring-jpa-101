package com.gluecoders.databasesqlexample.runners;

import com.gluecoders.databasesqlexample.dao.EmployeeDao;
import com.gluecoders.databasesqlexample.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BasicExampleRunner implements CommandLineRunner {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Saving an employee in database");
        Employee employee = new Employee();
        employee.setDob(new Date());
        employee.setFirstName("Anand");
        employee.setLastName("Rajneesh");
        employee.setGender("M");
        employeeDao.save(employee);
        System.out.println("Employee " + employee.getFirstName() + " saved with id "+ employee.getEmpId());

        employee = employeeDao.findByFirstName("Anand");
        System.out.println("Fetched employee " + employee.getFirstName() + " with id "+ employee.getEmpId()+ " dob "+ employee.getDob());

        System.out.println("Deleting employee");
        employeeDao.delete(employee);
        employee = employeeDao.findByFirstName("Anand");
        if(employee == null){
            System.out.println("Employee deleted");
        }else{
            System.out.println("Should have been deleted some error here");
            throw new IllegalStateException("This should not be allowed");
        }


    }
}

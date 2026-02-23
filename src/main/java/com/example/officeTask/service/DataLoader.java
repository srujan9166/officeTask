package com.example.officeTask.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.officeTask.enums.EmployeeStatus;
import com.example.officeTask.enums.Role;
import com.example.officeTask.model.Department;
import com.example.officeTask.model.Employee;
import com.example.officeTask.model.User;
import com.example.officeTask.repository.DepartmentRepository;
import com.example.officeTask.repository.EmployeeRepository;
import com.example.officeTask.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() == 0) {
                //admin signup
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(Role.ADMIN);
                //ceo signup
            User ceo = new User();
            ceo.setUsername("ceo");
            ceo.setPassword(passwordEncoder.encode("ceo123"));
            ceo.setRole(Role.CEO);

            Employee emp1 = new Employee();
            emp1.setName("srujan");
            emp1.setDesignation("Software Engineer");
            emp1.setSalary(60000.0);
            emp1.setStatus(EmployeeStatus.ACTIVE);
            emp1.setEmail("rallabandisaisrujan@gmail.com");
            emp1.setJoiningDate(java.time.LocalDate.of(2020, 1, 15));

            employeeRepository.save(emp1);

            //employee signup
            User newEmpUser = new User();
            newEmpUser.setUsername(emp1.getEmail());
            newEmpUser.setPassword(passwordEncoder.encode("employee"));
            newEmpUser.setRole(Role.EMPLOYEE);
            
           
          


            //manager signup
            Employee managerEmployee = new Employee();
            managerEmployee.setName("manager");
            managerEmployee.setDesignation("java developer");
            managerEmployee.setSalary(30000.0);
            managerEmployee.setStatus(EmployeeStatus.ACTIVE);
            managerEmployee.setEmail("manager@gmail.com");
            managerEmployee.setJoiningDate(java.time.LocalDate.of(2020, 1, 15));

            employeeRepository.save(managerEmployee);

            User newManUser = new User();
            newManUser.setUsername(managerEmployee.getName());
            newManUser.setPassword(passwordEncoder.encode("manager123"));
            newManUser.setRole(Role.MANAGER);
           


            userRepository.save(newManUser);
            userRepository.save(admin);
            userRepository.save(ceo);
            userRepository.save(newEmpUser);



            Department itDepartment = new Department();

            itDepartment.setName("IT DEPARTMENT");
            itDepartment.setManager(managerEmployee);
            departmentRepository.save(itDepartment);

           
        }
    }
}


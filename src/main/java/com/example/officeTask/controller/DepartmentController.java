package com.example.officeTask.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.officeTask.dto.DepartmentDTO;
import com.example.officeTask.dto.EmployeeDTO;
import com.example.officeTask.model.Department;
import com.example.officeTask.service.DepartmentService;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

   
    
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
     
 
    @PutMapping("/{department_id}/assign/{employee_id}")
    public DepartmentDTO assignManagerToDepartment(@PathVariable Long department_id , 
                                            @PathVariable Long employee_id){
                                                    return departmentService.assignManagerToDepartment(department_id,employee_id);
    }

   
    
    @PostMapping("/create")
    public DepartmentDTO createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @GetMapping("/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/departments")
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}/employees")
    public List<EmployeeDTO> getEmployeesByDepartment(@PathVariable Long id) {
        return departmentService.getEmployeesByDepartment(id);
    }

    @PostMapping("/{id}/employees")
    public EmployeeDTO createEmployeeInDepartment(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        return departmentService.createEmployeeInDepartment(id, employeeDTO);
    }


    public DepartmentService getDepartmentService() {
        return departmentService;
    }


    
 
    
   

}

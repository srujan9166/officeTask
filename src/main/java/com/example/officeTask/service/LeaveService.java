package com.example.officeTask.service;

import org.springframework.stereotype.Service;

import com.example.officeTask.dto.RequestDTO;
import com.example.officeTask.enums.LeaveStatus;

import com.example.officeTask.model.Employee;
import com.example.officeTask.model.Leave;
import com.example.officeTask.repository.EmployeeRepository;
import com.example.officeTask.repository.LeaveRepository;
@Service
public class LeaveService {

    private final LeaveRepository leaveRepository;
    private final EmployeeRepository employeeRepository;

    public LeaveService(LeaveRepository leaveRepository, EmployeeRepository employeeRepository){
        this.leaveRepository= leaveRepository;
        this.employeeRepository = employeeRepository;
    }

    public Leave createLeave(RequestDTO requestDTO) {
      Employee employee = employeeRepository.findById(requestDTO.getEmployee_id())
                                .orElseThrow(() -> new RuntimeException("Employee Not Found"));

        Leave leave = new Leave();
        leave.setEmployee(employee);
        leave.setStartDate(requestDTO.getStartDate());
        leave.setEndDate(requestDTO.getEndDate());
        leave.setLeaveStatus(LeaveStatus.PENDING);
        leave.setLeaveType(requestDTO.getLeaveType());
        leave.setReason(requestDTO.getReason());

      return  leaveRepository.save(leave);

    }


}

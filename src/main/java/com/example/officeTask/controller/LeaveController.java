package com.example.officeTask.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.officeTask.dto.RequestDTO;
import com.example.officeTask.model.Leave;
import com.example.officeTask.repository.LeaveRepository;
import com.example.officeTask.service.LeaveService;

@RestController
@RequestMapping("/leaves")
public class LeaveController {
   
    private final LeaveService leaveService;
   
    public LeaveController( LeaveService leaveService){
       
        this.leaveService= leaveService;
    }


    @PostMapping("/leaveRequest")
    public Leave createLeave(@RequestBody RequestDTO requestDTO){
        return leaveService.createLeave(requestDTO);
    }

    

}

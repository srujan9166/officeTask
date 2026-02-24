package com.example.officeTask.controller;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.officeTask.dto.LeaveRequestDTO;
import com.example.officeTask.dto.LeaveResponseDTO;
import com.example.officeTask.dto.LeaveSummaryDTO;
import com.example.officeTask.model.Leave;
import com.example.officeTask.service.LeaveService;

@RestController
@RequestMapping("/leaves")
public class LeaveController {
   
    private final LeaveService leaveService;
   
    public LeaveController( LeaveService leaveService){
       
        this.leaveService= leaveService;
    }


    @PostMapping("/leaveRequest")
    public LeaveResponseDTO createLeave(@RequestBody LeaveRequestDTO requestDTO){
        return leaveService.createLeave(requestDTO);
    }

    @PutMapping("/{id}/approve")
    public LeaveResponseDTO approveLeave(@PathVariable Long id){
        return leaveService.approveLeave(id);
    }

    @PutMapping("/{id}/reject")
    public LeaveResponseDTO rejectLeave(@PathVariable Long id){
        return leaveService.rejectLeave(id);
    }

    @GetMapping("/allLeaves")
    public List<LeaveResponseDTO> getAllLeaves(){
        return leaveService.getAllLeaves();
    }
    @GetMapping("/leaveStatus")
    public LeaveResponseDTO leaveStatus(){
        return leaveService.leaveStatus();
    }

    @GetMapping("/allApproved")
    public List<LeaveResponseDTO> allApproved(){
        return leaveService.allApproved();
    }

    @GetMapping("/active-today")
    public List<LeaveResponseDTO> todayLeaves(){
        return leaveService.todayLeaves();
    }

     @GetMapping("/{id}/leaves/summary")
    public LeaveSummaryDTO note(@PathVariable Long id){
        return leaveService.note(id);
    }

    

}

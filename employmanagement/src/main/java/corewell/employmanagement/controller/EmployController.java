package corewell.employmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import corewell.employmanagement.model.Employ;
import corewell.employmanagement.repository.EmployRepository;

@RestController
public class EmployController {
	
	
	@Autowired
	private EmployRepository employRepository;
	
	@GetMapping("/showAll")
	public List<Employ>  showALlEmploys(){
		
		return employRepository.findAll();
	}	
	
	@PostMapping("/addemploy")
	public String addEmploy(@RequestBody Employ employ) {
	
		employRepository.save(employ);
		return "Inserted successfully..";	
	}	
	
      @GetMapping("/employ/{empId}")
	public Employ searchEmploy(@PathVariable("empId") int empId) {
		  
    	  try {
    		  
    		return   employRepository.findById(empId).get();    		  
    		  
    	  }catch(Exception e) {
    		  return null;
    	  }    	  
	}
      
      @PutMapping("/employ")      
      public String updateEmploy(@RequestBody Employ newEmploy) {
    	  
    	  try {
    		  
      		Employ oldEmp =    employRepository.findById(newEmploy.getEmpId()).get();      		
      		oldEmp.setEmpName(newEmploy.getEmpName());
      		oldEmp.setEmpSalary(newEmploy.getEmpSalary());
      		oldEmp.setAddress(newEmploy.getAddress());
      		employRepository.save(oldEmp);
      		return "Updated successfully...";      		
      		  
      	  }catch(Exception e) {
      		  return "No record found with given Id "+ newEmploy.getEmpId();
      	  }        	  
      }
      
      @DeleteMapping("/employ/{empId}")
      public String deleteEmp(@PathVariable("empId") int empId) {
    	  
    	  try {    		  
        		Employ oldEmp =    employRepository.findById(empId).get();           		
        		employRepository.delete(oldEmp);
        		return "deleted successfully...";      		
        		  
        	  }catch(Exception e) {
        		  return "No record found with given Id "+ empId;
        	  }    
    	  
      }
}

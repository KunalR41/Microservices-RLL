package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.*;
import com.example.service.AdminService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@Controller
@Scope("request")
@RequestMapping("/admin")
public class AdminController {
	
    @Autowired
    @Qualifier("adminService")
	private AdminService adminservice;
    
    @HystrixCommand
    @GetMapping(value="/")
    public String check() {
    	return "Welcome......"; 
    }
    
    @HystrixCommand
    @PostMapping("/adminlogin")
	public Admin loginuser(@RequestBody Admin admin) throws Exception {
		String tempEmailId = admin.getEmailId();
		String tempPass=admin.getPassword();
		Admin adminObj = null;
		if(tempEmailId != null && tempPass != null ) {
			
			adminObj = adminservice.findByEmailIdAndPassword(tempEmailId, tempPass);
					
		}
		if(adminObj ==null) {
			throw new Exception("Bad  Credentials");
		}
			
		return adminObj;
	
	}
    
    @HystrixCommand
	@GetMapping(value="/findall" ,produces={MediaType.APPLICATION_JSON_VALUE})
	public List<Admin> findAll(){
		return adminservice.findAll();
	}

}
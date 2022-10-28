package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.*;
import com.example.service.AdminService;

@RestController
@Controller
@Scope("request")
@RequestMapping("/admin")
public class AdminController {
	
    @Autowired
    @Qualifier("adminService")
	private AdminService adminservice;
    @GetMapping(value="/")
    public void check() {
    	System.out.println("Welcome......"); 
    }

    @PostMapping("/adminlogin")
	public Admin loginuser(@RequestBody Admin admin) throws Exception {
		String tempEmailId = admin.getEmailId();
		String tempPass=admin.getPassword();
		Admin adminObj = null;
		if(tempEmailId != null && tempPass != null ) {
			
			adminObj = adminservice.fetchAdminByEmailIdandPassword(tempEmailId, tempPass);
					
		}
		if(adminObj ==null) {
			throw new Exception("Bad  Credentials");
		}
			
		return adminObj;
	
	}

}
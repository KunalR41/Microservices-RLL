package com.example.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.entity.Admin;
import com.example.repository.AdminRepository;





@Service("adminService")
public class AdminService {

	@Autowired
	@Qualifier("adminRepository")
	private AdminRepository repo;
	
	public Admin saveAdmin(Admin admin){
		return repo.save(admin);
		}
	public Admin fetchAdminByEmailId(String email)
	{
		return repo.findByEmailId(email);
	}
	
	public Admin fetchAdminByEmailIdandPassword(String email, String password)
	{
		return repo.findByEmailIdAndPassword(email, password);
	}
}
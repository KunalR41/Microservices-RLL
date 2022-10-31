package com.example.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.entity.Admin;
import com.example.repository.AdminRepository;





@Scope("singleton")
@Service("adminService")
public class AdminService implements AdminServiceimp{

	@Autowired
	@Qualifier("adminRepository")
	private AdminRepository repo;
	
	@Override
	public List<Admin> findAll() {
		return repo.findAll();
	}
	@Override
	public Admin findByEmail(String emailId) {
		return repo.findByEmailId(emailId);
	}
	@Override
	public void save(Admin admin) {
		repo.save(admin);
		
	}
	@Override
	public Admin findByEmailIdAndPassword(String emailId, String password) {
		return repo.findByEmailIdAndPassword(emailId, password);
	}
	
	
}
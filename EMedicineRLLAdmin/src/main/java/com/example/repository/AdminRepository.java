package com.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Admin;
//import com.example.demo.domain.User;



@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	public Admin findByEmailId(String emailId);
	public Admin findByEmailIdAndPassword(String emailId, String password);

}


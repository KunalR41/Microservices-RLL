package com.example.service;


import java.util.List;

import com.example.entity.Admin;




public interface AdminServiceimp {

	Admin findByEmail(String user);
	void save(Admin admin);
	List<Admin> findAll();
	Admin findByEmailIdAndPassword(String emailId, String password);
}
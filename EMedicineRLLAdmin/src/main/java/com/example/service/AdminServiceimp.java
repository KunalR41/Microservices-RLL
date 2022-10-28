package com.example.service;


import java.util.List;

import com.example.entity.Admin;




public interface AdminServiceimp {

	List<Admin> findByRole(String user);
	Admin findByEmail(String user);
	void save(Admin admin);
	List<Admin> findAll();
}
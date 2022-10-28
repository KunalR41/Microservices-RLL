package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.Admin;
import com.example.repository.AdminRepository;

@SpringBootApplication
public class EMedicineRllAdminApplication implements CommandLineRunner{

	@Autowired
	@Qualifier("adminRepository")
	private AdminRepository adminRepository;

	public static void main(String[] args) {
		SpringApplication.run(EMedicineRllAdminApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
		adminRepository.save(new Admin(0,"xyz@gmail.com","xyz","123"));
		adminRepository.save(new Admin(0,"abc@gmail.com","abc","123"));
		adminRepository.save(new Admin(0,"efg@gmail.com","efg","123"));
		adminRepository.save(new Admin(0,"mno@gmail.com","mno","123"));
	}

}

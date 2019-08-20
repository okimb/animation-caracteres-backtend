package com.ifi_gp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifi_gp.entitees.Users;

public interface IUser extends JpaRepository<Users, Long> {
	Users findByMailAndPassword(String mail, String password);

}

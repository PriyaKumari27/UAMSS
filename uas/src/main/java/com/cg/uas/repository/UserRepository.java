package com.cg.uas.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.uas.dto.User;

/*
 * @author : Priya Kumari
 * Description : User Repository
 * Created on : 16-12-2019
 */
@Repository

public interface UserRepository extends JpaRepository<User, BigInteger> {

	

}

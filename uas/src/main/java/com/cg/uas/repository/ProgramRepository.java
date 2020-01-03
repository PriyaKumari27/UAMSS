package com.cg.uas.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.uas.dto.Program;


/*
 * @author : Priya Kumari
 * Description : Program Repository
 * Created on : 16-12-2019
 */
@Repository
public interface ProgramRepository extends JpaRepository<Program, BigInteger> {

	

}

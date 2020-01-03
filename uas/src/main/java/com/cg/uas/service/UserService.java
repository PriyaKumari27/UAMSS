package com.cg.uas.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.uas.dto.Applicant;
import com.cg.uas.dto.Program;
import com.cg.uas.dto.ScheduleAvailable;
import com.cg.uas.exception.ValidationException;

public interface UserService {


	public ScheduleAvailable addSchedule(ScheduleAvailable schedule);
	public boolean removeSchedule(BigInteger scheduleId) throws ValidationException; 
	public ScheduleAvailable findSchedule(BigInteger scheduleId);
	public List<ScheduleAvailable> getScheduleList();

	
	public Program addProgram(BigInteger programId, Program program);
	public boolean removeProgram(BigInteger removeScheduleId, BigInteger removeProgramId) throws ValidationException;
	public List<Program> getListOfPrograms(BigInteger scheduleId);
	public Program findProgram(BigInteger programId);
	
	public Applicant addApplicant(Applicant applicant);
	public List<Applicant> getScheduleApplicantList(BigInteger scheduleId) throws ValidationException;
	public List<Applicant> getApplicants();
	
	public BigInteger validateScheduleId(String centerId, List<ScheduleAvailable> scheduleList)throws ValidationException;
	public BigInteger validateProgramId(String programId,List<Program> programList)throws ValidationException;
	public BigInteger validateApplicantId(String applicantId, List<Applicant> listOfApplicant)throws ValidationException;
	
	public boolean approveApplicant(BigInteger applicantId) throws ValidationException;
	public boolean rejectApplicant(BigInteger applicantId);
	
	



}

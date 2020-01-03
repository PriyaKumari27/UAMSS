package com.cg.uas.controller;



import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.uas.dto.Applicant;
import com.cg.uas.dto.ApplicantRequest;
import com.cg.uas.dto.Program;
import com.cg.uas.dto.ScheduleAvailable;
import com.cg.uas.exception.ValidationException;
import com.cg.uas.service.UserServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class UASController {

	@Autowired
	private UserServiceImpl userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UASController.class);
	
	


	/*
	* @author         : Priya Kumari
	* Description     : Add Schedule
	* Input           : ScheduleAvailable schedule
	* Output          : ResponseEntity<ScheduleAvailable>
	* Created on      : 16-12-2019
	* Last Modified on: 16-12-2019
	*/
	
	@PostMapping("/addSchedule")
	public ResponseEntity<?> addSchedule(@RequestBody ScheduleAvailable schedule) {

		ScheduleAvailable newSchedule = userService.addSchedule(schedule);

		if (newSchedule == null) {
			return new ResponseEntity<String>("Schedule not added", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			 logger.info("Schedule added. Audit Details: ScheduleID:"+newSchedule.getScheduleId()+" Created on:"+newSchedule.getCreationDate()+".Created by: "+newSchedule.getCreatedBy());
			return new ResponseEntity<ScheduleAvailable>(newSchedule, HttpStatus.OK);
		}
	}
	

	/*
	* @author         : Priya Kumari
	* Description     : getSchedule
	* Input           : NULL
	* Output          : scheduleList
	* Created on      : 16-12-2019
	* Last Modified on: 16-12-2019
	*/
	
	
	@GetMapping(value = "/getSchedule")
	public ResponseEntity<List<ScheduleAvailable>> getSchedule() {
		logger.info("Getting list of all schedules in the system..");
		List<ScheduleAvailable> scheduleList = userService.getScheduleList();
		if (scheduleList.size() == 0) {
			logger.info("No schedules present in the system. Returning NO_CONTENT");
			return new ResponseEntity<List<ScheduleAvailable>>(HttpStatus.NO_CONTENT);
		} else {
			// logger.info("Returning schedule list..");
			return new ResponseEntity<List<ScheduleAvailable>>(scheduleList, HttpStatus.OK);
		}
	}

	
	/*
	* @author         : Priya Kumari
	* Description     : Remove Schedule
	* Input           : scheduleId
	* Output          : String Message
	* Created on      : 16-12-2019
	* Last Modified on: 16-12-2019
	*/
	
	@DeleteMapping("/removeSchedule")
	public ResponseEntity<?> deleteSchedule(@RequestParam("scheduleId") String stringScheduleId) throws Exception {
		boolean remove = false;
		BigInteger scheduleId = null;
		try {
			scheduleId = userService.validateScheduleId(stringScheduleId, userService.getScheduleList());
			remove = userService.removeSchedule(scheduleId);
			if (remove == true) {
				return new ResponseEntity<String>("Schedule deleted successfully", HttpStatus.OK);
			} else
				return new ResponseEntity<String>(" Schedule not deleted", HttpStatus.OK);

		} catch (ValidationException exception) {
			logger.error("Caught Validation Exception in /deleteSchedule Controller...");
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/*
	* @author         : Priya Kumari
	* Description     : Add Program
	* Input           : scheduleId, Program program
	* Output          : program
	* Created on      : 17-12-2019
	* Last Modified on: 17-12-2019
	*/
	
	@PostMapping("/addProgram")
	public ResponseEntity<?> addProgram(@RequestParam("scheduleId") String id, @ModelAttribute Program program)
			throws ValidationException {
		try {
			logger.info("Validating schedule Id entered for add Program..");
			BigInteger scheduleId = userService.validateScheduleId(id, userService.getScheduleList());
			System.out.println(program);
			
			Program newProgram = userService.addProgram(scheduleId, program);
			System.out.println(newProgram);
			
			logger.info("adding program to the given scheduleId");
			if (newProgram == null) {
				return new ResponseEntity<String>("Data not added", HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				 logger.info("Program added! AUDIT TRAIL=> Created on:"+newProgram.getCreationDate()+" Created by: "+newProgram.getCreatedBy());
				return new ResponseEntity<Program>(newProgram, HttpStatus.OK);
			}
		} catch (ValidationException exception) {
			// logger.error("Caught Validation Exception in /addPrograms Controller... ");
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	

	/*
	* @author         : Priya Kumari
	* Description     : Get Programs
	* Input           : scheduleId
	* Output          : programList
	* Created on      : 17-12-2019
	* Last Modified on: 17-12-2019
	*/

	@GetMapping(value = "/getPrograms")
	public ResponseEntity<List<Program>> getPrograms(@RequestParam("scheduleId") String stringScheduleId) {
		BigInteger scheduleId = null;
		List<Program> programList = null;
		try {
			 logger.info("Validating schedule id entered as parameter..");
			scheduleId = userService.validateScheduleId(stringScheduleId, userService.getScheduleList());
			logger.info("Schedule Id validated... Getting program List");
			programList = userService.getListOfPrograms(scheduleId);
			if (programList.size() > 0) {
				logger.info("Returning program list in the schedule..");
				return new ResponseEntity<List<Program>>(programList, HttpStatus.OK);
			} else {
				logger.info("Program list is empty.");
				return new ResponseEntity<List<Program>>(HttpStatus.NO_CONTENT);
			}
		} catch (ValidationException exception) {
			logger.error("Caught Validation Exception in /getPrograms Controller... ");
			return new ResponseEntity<List<Program>>(HttpStatus.BAD_REQUEST);
		}
	}

	
	
	
	/*
	* @author         : Priya Kumari
	* Description     : Remove Program
	* Input           : scheduleId
	* Output          : Message
	* Created on      : 17-12-2019
	* Last Modified on: 17-12-2019
	*/

	@DeleteMapping("/removeProgram")
	public ResponseEntity<?> deleteProgram(@RequestParam("scheduleId") String stringScheduleId,
			@RequestParam("programId") String stringProgramId) throws Exception {
		boolean remove = false;
		BigInteger scheduleId = null;
		BigInteger programId = null;
		try {

			scheduleId = userService.validateScheduleId(stringScheduleId, userService.getScheduleList());
			programId = userService.validateProgramId(stringProgramId, userService.getListOfPrograms(scheduleId));
			remove = userService.removeProgram(scheduleId, programId);
			logger.info("removing program from the given scheduleId");

			if (remove == true)
				return new ResponseEntity<String>("program deleted", HttpStatus.OK);
			else if (remove == false)
				return new ResponseEntity<String>("Data not deleted", HttpStatus.OK);
			else
				return new ResponseEntity<String>("Data not added", HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (ValidationException exception) {
			logger.error("Caught Validation Exception in /removeProgram Controller... ");
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/*
	* @author         : Priya Kumari
	* Description     : Add applicant
	* Input           : scheduleId , programId
	* Output          : ResponseEntity<Applicant>
	* Created on      : 18-12-2019
	* Last Modified on: 18-12-2019
	*/
	
	@PostMapping(value="/addApplicant")
	public ResponseEntity<?> addApplicant(@RequestParam BigInteger scheduleId, BigInteger programId  , @RequestBody Applicant applicant) {
		
		try{
			logger.info("Getting the schedule corresponding to the schedule Id");
			ScheduleAvailable schedule = userService.findSchedule(scheduleId);
			
			logger.info("Getting the program corresponding to the program Id");
			Program program = userService.findProgram(programId);
			
			
			
			logger.info("All inputs valid.. creating applicant");
			
			applicant.setSchedule(schedule);
			applicant.setProgram(program);
			logger.info("Applicant created.. returning applicant object");
			applicant = userService.addApplicant(applicant);
			logger.info("New Applicant Added. AUDIT TRAIL=> Applicant ID: "+applicant.getApplicantId()+" Created on: "+applicant.getCreationDate()+" Created by: "+applicant.getCreatedBy());
			return new ResponseEntity<Applicant>(applicant,HttpStatus.OK);
			}
			catch(Exception exception) {
			logger.error("Caught validation exception in /addApplicant Controller");
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
			}
	}
	
	/*
	* @author         : Priya Kumari
	* Description     : view applicant
	* Input           : NULL
	* Output          : applicantList
	* Created on      : 18-12-2019
	* Last Modified on: 18-12-2019
	*/
	
	@GetMapping(value="/viewApplicants")
	public ResponseEntity<?> viewApplicants(){
		List<Applicant> applicantList = userService.getApplicants();
		if(applicantList.size() > 0) {
			logger.info("Returning appointment list");
			return new ResponseEntity<List<Applicant>>(applicantList, HttpStatus.OK);
		}else {
			logger.info("0 applicants in the system.. returning nothing");
			return new ResponseEntity<String>("You have no applicants", HttpStatus.NO_CONTENT);
		}
	}
	
	/*
	* @author         : Priya Kumari
	* Description     : pending applicants
	* Input           : scheduleId
	* Output          : ResponseEntity<List<Applicant>>
	* Created on      : 18-12-2019
	* Last Modified on: 18-12-2019
	*/
	
	@GetMapping(value="/pendingApplicants")
	public ResponseEntity<?> pendingApplicants(@RequestParam("scheduleId") String stringScheduleId){
		BigInteger scheduleId = null;
		try {
			logger.info("Validating schedule Id entered for applicant..");
			scheduleId = userService.validateScheduleId(stringScheduleId, userService.getScheduleList());
			logger.info("Getting applicants corresponding to the schedule id..");
			List<Applicant> applicantList = userService.getScheduleApplicantList(scheduleId);
			if(applicantList.size() > 0) {
				logger.info("Returning Applicant list to the admin..");
				return new ResponseEntity<List<Applicant>>(applicantList, HttpStatus.OK);
			}else {
				logger.info("0 Applicants in the system from this schedule.. returning nothing");
				return new ResponseEntity<String>("No Applicants in this schedule", HttpStatus.NO_CONTENT);
			}
		}catch(ValidationException exception) {
			logger.error("Caught validation exception in /pendingApplicants Controller");
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	/*
	* @author         : Priya Kumari
	* Description     : approve applicant
	* Input           : applicantId
	* Output          : Message
	* Created on      : 18-12-2019
	* Last Modified on: 18-12-2019
	*/

	@PostMapping(value="/approveApplicant")
	public ResponseEntity<?> approveApplicants(@RequestParam("applicantId") String stringApplicantId){
		BigInteger applicantId = null;
		try {
			logger.info("Validating Applicant Id selected for approval");
			applicantId = userService.validateApplicantId(stringApplicantId, userService.getApplicants());
			logger.info("Applicant Id Validated... approving Applicant.");
			if(userService.approveApplicant(applicantId)) {
				
				return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			}
			return null;
		}catch(ValidationException exception) {
			logger.error("Caught validation exception in /approveApplicant Controller");
			return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	

	/*
	* @author         : Priya Kumari
	* Description     : reject applicant
	* Input           : applicantId
	* Output          : Message
	* Created on      : 18-12-2019
	* Last Modified on: 18-12-2019
	*/

	@PostMapping("/rejectapplicant")
	public ResponseEntity<?> rejectApplicant(@RequestParam("applicantId") BigInteger applicantId)
	{
		
			if(userService.rejectApplicant(applicantId)) {
				return new ResponseEntity<String>("Applicant Rejected!", HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("Please try again",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	}
}

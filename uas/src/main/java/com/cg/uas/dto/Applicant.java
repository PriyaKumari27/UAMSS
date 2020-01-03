package com.cg.uas.dto;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;


/*
 * @author : Priya Kumari
 * Description : Applicant dto
 * Created on : 16-12-2019
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="uas_applicant")
public class Applicant {

	@Id @GeneratedValue
	@Column(name="applicant_id")
	private BigInteger applicantId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="schedule_id_fk")
	private ScheduleAvailable schedule;  	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="program_id_fk")
	private Program program;
	
	@Column(name="applicant_applied_status")
	private int applicantAppliedStatus;
	
	@Column(name="applicant_accepted_status")
	private int applicantAcceptedStatus;
	
	@Column(name="applicant_confirm_status")
	private int applicantConfirmedStatus;
	
	@Column(name = "applicant_name")
	private String applicantName;
	
	@Column(name = "applicant_contact_no")
	private BigInteger contactNo;
	
	@Column(name = "applicant_email")
	private String applicantEmail;
	
	@Column(name = "applicant_age")
	private Integer applicantAge;
	
	@Column(name = "applicant_gender")
	private String applicantGender;
	
	@Column(name = "applicant_address")
	private String applicantAddress;
	
	@Column(name = "applicant_city")
	private String applicantCity;
	
	@Column(name = "applicant_school_name")
	private String applicantSchoolName;
	
	@Column(name = "applicant_hsc")
	private String applicantHscPercentage;
	

	@Column(name = "applicant_ssc")
	private String applicantSscPercentage;

	@Column(name = "applicant_jee")
	private String applicantJEEMarks;
	
	
	@CreatedBy
	protected String createdBy;
	
	@CreatedDate	
	@Temporal(TemporalType.TIMESTAMP)
	protected Date creationDate;
	
	@LastModifiedBy
	protected String lastModifiedBy;
	
	@LastModifiedDate
	protected String lastModifiedDate;
	
	public Applicant() {
		// TODO Auto-generated constructor stub
	}

	public Applicant(BigInteger applicantId, ScheduleAvailable schedule, Program program, int applicantAppliedStatus,
			int applicantAcceptedStatus, int applicantConfirmedStatus, String applicantName, BigInteger contactNo,
			String applicantEmail, Integer applicantAge, String applicantGender, String applicantAddress,
			String applicantCity, String applicantSchoolName, String applicantHscPercentage,
			String applicantSscPercentage, String applicantJEEMarks) {
		super();
		this.applicantId = applicantId;
		this.schedule = schedule;
		this.program = program;
		this.applicantAppliedStatus = applicantAppliedStatus;
		this.applicantAcceptedStatus = applicantAcceptedStatus;
		this.applicantConfirmedStatus = applicantConfirmedStatus;
		this.applicantName = applicantName;
		this.contactNo = contactNo;
		this.applicantEmail = applicantEmail;
		this.applicantAge = applicantAge;
		this.applicantGender = applicantGender;
		this.applicantAddress = applicantAddress;
		this.applicantCity = applicantCity;
		this.applicantSchoolName = applicantSchoolName;
		this.applicantHscPercentage = applicantHscPercentage;
		this.applicantSscPercentage = applicantSscPercentage;
		this.applicantJEEMarks = applicantJEEMarks;
	}

	public BigInteger getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(BigInteger applicantId) {
		this.applicantId = applicantId;
	}

	public ScheduleAvailable getSchedule() {
		return schedule;
	}

	public void setSchedule(ScheduleAvailable schedule) {
		this.schedule = schedule;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public int getApplicantAppliedStatus() {
		return applicantAppliedStatus;
	}

	public void setApplicantAppliedStatus(int applicantAppliedStatus) {
		this.applicantAppliedStatus = applicantAppliedStatus;
	}

	public int getApplicantAcceptedStatus() {
		return applicantAcceptedStatus;
	}

	public void setApplicantAcceptedStatus(int applicantAcceptedStatus) {
		this.applicantAcceptedStatus = applicantAcceptedStatus;
	}

	public int getApplicantConfirmedStatus() {
		return applicantConfirmedStatus;
	}

	public void setApplicantConfirmedStatus(int applicantConfirmedStatus) {
		this.applicantConfirmedStatus = applicantConfirmedStatus;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public BigInteger getContactNo() {
		return contactNo;
	}

	public void setContactNo(BigInteger contactNo) {
		this.contactNo = contactNo;
	}

	public String getApplicantEmail() {
		return applicantEmail;
	}

	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}

	public Integer getApplicantAge() {
		return applicantAge;
	}

	public void setApplicantAge(Integer applicantAge) {
		this.applicantAge = applicantAge;
	}

	public String getApplicantGender() {
		return applicantGender;
	}

	public void setApplicantGender(String applicantGender) {
		this.applicantGender = applicantGender;
	}

	public String getApplicantAddress() {
		return applicantAddress;
	}

	public void setApplicantAddress(String applicantAddress) {
		this.applicantAddress = applicantAddress;
	}

	public String getApplicantCity() {
		return applicantCity;
	}

	public void setApplicantCity(String applicantCity) {
		this.applicantCity = applicantCity;
	}

	public String getApplicantSchoolName() {
		return applicantSchoolName;
	}

	public void setApplicantSchoolName(String applicantSchoolName) {
		this.applicantSchoolName = applicantSchoolName;
	}

	public String getApplicantHscPercentage() {
		return applicantHscPercentage;
	}

	public void setApplicantHscPercentage(String applicantHscPercentage) {
		this.applicantHscPercentage = applicantHscPercentage;
	}

	public String getApplicantSscPercentage() {
		return applicantSscPercentage;
	}

	public void setApplicantSscPercentage(String applicantSscPercentage) {
		this.applicantSscPercentage = applicantSscPercentage;
	}

	public String getApplicantJEEMarks() {
		return applicantJEEMarks;
	}

	public void setApplicantJEEMarks(String applicantJEEMarks) {
		this.applicantJEEMarks = applicantJEEMarks;
	}

	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + applicantAcceptedStatus;
		result = prime * result + ((applicantAddress == null) ? 0 : applicantAddress.hashCode());
		result = prime * result + ((applicantAge == null) ? 0 : applicantAge.hashCode());
		result = prime * result + applicantAppliedStatus;
		result = prime * result + ((applicantCity == null) ? 0 : applicantCity.hashCode());
		result = prime * result + applicantConfirmedStatus;
		result = prime * result + ((applicantEmail == null) ? 0 : applicantEmail.hashCode());
		result = prime * result + ((applicantGender == null) ? 0 : applicantGender.hashCode());
		result = prime * result + ((applicantHscPercentage == null) ? 0 : applicantHscPercentage.hashCode());
		result = prime * result + ((applicantId == null) ? 0 : applicantId.hashCode());
		result = prime * result + ((applicantJEEMarks == null) ? 0 : applicantJEEMarks.hashCode());
		result = prime * result + ((applicantName == null) ? 0 : applicantName.hashCode());
		result = prime * result + ((applicantSchoolName == null) ? 0 : applicantSchoolName.hashCode());
		result = prime * result + ((applicantSscPercentage == null) ? 0 : applicantSscPercentage.hashCode());
		result = prime * result + ((contactNo == null) ? 0 : contactNo.hashCode());
		result = prime * result + ((program == null) ? 0 : program.hashCode());
		result = prime * result + ((schedule == null) ? 0 : schedule.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Applicant other = (Applicant) obj;
		if (applicantAcceptedStatus != other.applicantAcceptedStatus)
			return false;
		if (applicantAddress == null) {
			if (other.applicantAddress != null)
				return false;
		} else if (!applicantAddress.equals(other.applicantAddress))
			return false;
		if (applicantAge == null) {
			if (other.applicantAge != null)
				return false;
		} else if (!applicantAge.equals(other.applicantAge))
			return false;
		if (applicantAppliedStatus != other.applicantAppliedStatus)
			return false;
		if (applicantCity == null) {
			if (other.applicantCity != null)
				return false;
		} else if (!applicantCity.equals(other.applicantCity))
			return false;
		if (applicantConfirmedStatus != other.applicantConfirmedStatus)
			return false;
		if (applicantEmail == null) {
			if (other.applicantEmail != null)
				return false;
		} else if (!applicantEmail.equals(other.applicantEmail))
			return false;
		if (applicantGender == null) {
			if (other.applicantGender != null)
				return false;
		} else if (!applicantGender.equals(other.applicantGender))
			return false;
		if (applicantHscPercentage == null) {
			if (other.applicantHscPercentage != null)
				return false;
		} else if (!applicantHscPercentage.equals(other.applicantHscPercentage))
			return false;
		if (applicantId == null) {
			if (other.applicantId != null)
				return false;
		} else if (!applicantId.equals(other.applicantId))
			return false;
		if (applicantJEEMarks == null) {
			if (other.applicantJEEMarks != null)
				return false;
		} else if (!applicantJEEMarks.equals(other.applicantJEEMarks))
			return false;
		if (applicantName == null) {
			if (other.applicantName != null)
				return false;
		} else if (!applicantName.equals(other.applicantName))
			return false;
		if (applicantSchoolName == null) {
			if (other.applicantSchoolName != null)
				return false;
		} else if (!applicantSchoolName.equals(other.applicantSchoolName))
			return false;
		if (applicantSscPercentage == null) {
			if (other.applicantSscPercentage != null)
				return false;
		} else if (!applicantSscPercentage.equals(other.applicantSscPercentage))
			return false;
		if (contactNo == null) {
			if (other.contactNo != null)
				return false;
		} else if (!contactNo.equals(other.contactNo))
			return false;
		if (program == null) {
			if (other.program != null)
				return false;
		} else if (!program.equals(other.program))
			return false;
		if (schedule == null) {
			if (other.schedule != null)
				return false;
		} else if (!schedule.equals(other.schedule))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApplicantRepository [applicantId=" + applicantId + ", schedule=" + schedule + ", program=" + program
				+ ", applicantAppliedStatus=" + applicantAppliedStatus + ", applicantAcceptedStatus="
				+ applicantAcceptedStatus + ", applicantConfirmedStatus=" + applicantConfirmedStatus
				+ ", applicantName=" + applicantName + ", contactNo=" + contactNo + ", applicantEmail=" + applicantEmail
				+ ", applicantAge=" + applicantAge + ", applicantGender=" + applicantGender + ", applicantAddress="
				+ applicantAddress + ", applicantCity=" + applicantCity + ", applicantSchoolName=" + applicantSchoolName
				+ ", applicantHscPercentage=" + applicantHscPercentage + ", applicantSscPercentage="
				+ applicantSscPercentage + ", applicantJEEMarks=" + applicantJEEMarks + "]";
	}
	
	

}



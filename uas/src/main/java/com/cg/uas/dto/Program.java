package com.cg.uas.dto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
 * Description : Program dto
 * Created on : 16-12-2019
 */
@Entity

@EntityListeners(AuditingEntityListener.class)
@Table(name = "uas_program")
public class Program {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "program_id")
	private BigInteger programId;

	@Column(name = "program_name")
	private String programName;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@JsonIgnore
	@OneToMany(mappedBy = "program")
	List<Applicant> ApplicantList = new ArrayList<Applicant>();
	
	@CreatedBy
	protected String createdBy;
	
	@CreatedDate	
	@Temporal(TemporalType.TIMESTAMP)
	protected Date creationDate;
	
	@LastModifiedBy
	protected String lastModifiedBy;
	
	@LastModifiedDate
	protected String lastModifiedDate;
	

	public Program() {
		// TODO Auto-generated constructor stub
	}

	public Program(BigInteger programId, String programName, boolean isDeleted, List<Applicant> applicantList) {
		super();
		this.programId = programId;
		this.programName = programName;
		this.isDeleted = isDeleted;
		ApplicantList = applicantList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ApplicantList == null) ? 0 : ApplicantList.hashCode());
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((programName == null) ? 0 : programName.hashCode());
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
		Program other = (Program) obj;
		if (ApplicantList == null) {
			if (other.ApplicantList != null)
				return false;
		} else if (!ApplicantList.equals(other.ApplicantList))
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (programId == null) {
			if (other.programId != null)
				return false;
		} else if (!programId.equals(other.programId))
			return false;
		if (programName == null) {
			if (other.programName != null)
				return false;
		} else if (!programName.equals(other.programName))
			return false;
		return true;
	}

	public BigInteger getProgramId() {
		return programId;
	}

	public void setProgramId(BigInteger programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<Applicant> getApplicantList() {
		return ApplicantList;
	}

	public void setApplicantList(List<Applicant> applicantList) {
		ApplicantList = applicantList;
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
	public String toString() {
		return "ProgramRepository [programId=" + programId + ", programName=" + programName + ", isDeleted=" + isDeleted
				+ ", ApplicantList=" + ApplicantList + "]";
	}

}

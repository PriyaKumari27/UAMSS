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
import javax.persistence.JoinColumn;
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
 * Description : ScheduleAvailable dto
 * Created on : 16-12-2019
 */
@Entity


@EntityListeners(AuditingEntityListener.class)
@Table(name="uas_schedule")
public class ScheduleAvailable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "schedule_id")
	private BigInteger scheduleId;
	
	@Column(name = "schedule_month")
	private String scheduleMonth;
	
	@Column(name="is_deleted")
	private boolean isDeleted;
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name="schedule_id_fk")
	private List<Program> listOfPrograms = new ArrayList<Program>();

	@JsonIgnore
	@OneToMany(mappedBy = "schedule")
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
	
//	
	public ScheduleAvailable() {
		// TODO Auto-generated constructor stub
	}

	public ScheduleAvailable(BigInteger scheduleId, String scheduleMonth, boolean isDeleted,
			List<Program> listOfPrograms, List<Applicant> applicantList) {
		super();
		this.scheduleId = scheduleId;
		this.scheduleMonth = scheduleMonth;
		this.isDeleted = isDeleted;
		this.listOfPrograms = listOfPrograms;
		//ApplicantList = applicantList;
	}

	public BigInteger getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(BigInteger scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getScheduleMonth() {
		return scheduleMonth;
	}

	public void setScheduleMonth(String scheduleMonth) {
		this.scheduleMonth = scheduleMonth;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<Program> getListOfPrograms() {
		return listOfPrograms;
	}

	public void setListOfPrograms(List<Program> listOfPrograms) {
		this.listOfPrograms = listOfPrograms;
	}

//	public List<Applicant> getApplicantList() {
//		return ApplicantList;
//	}
//
//	public void setApplicantList(List<Applicant> applicantList) {
//		ApplicantList = applicantList;
//	}
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((ApplicantList == null) ? 0 : ApplicantList.hashCode());
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + ((listOfPrograms == null) ? 0 : listOfPrograms.hashCode());
		result = prime * result + ((scheduleId == null) ? 0 : scheduleId.hashCode());
		result = prime * result + ((scheduleMonth == null) ? 0 : scheduleMonth.hashCode());
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
		ScheduleAvailable other = (ScheduleAvailable) obj;
//		if (ApplicantList == null) {
//			if (other.ApplicantList != null)
//				return false;
//		} else if (!ApplicantList.equals(other.ApplicantList))
//			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (listOfPrograms == null) {
			if (other.listOfPrograms != null)
				return false;
		} else if (!listOfPrograms.equals(other.listOfPrograms))
			return false;
		if (scheduleId == null) {
			if (other.scheduleId != null)
				return false;
		} else if (!scheduleId.equals(other.scheduleId))
			return false;
		if (scheduleMonth == null) {
			if (other.scheduleMonth != null)
				return false;
		} else if (!scheduleMonth.equals(other.scheduleMonth))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ScheduleAvailable [scheduleId=" + scheduleId + ", scheduleMonth=" + scheduleMonth + ", isDeleted="
				+ isDeleted + ", listOfPrograms=" + listOfPrograms + ", ]";
	}
	
	
}

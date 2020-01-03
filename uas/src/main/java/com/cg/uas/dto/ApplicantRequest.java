package com.cg.uas.dto;

/*
 * @author : Priya Kumari
 * Description : Applicant Request dto
 * Created on : 16-12-2019
 */


public class ApplicantRequest {
	private String scheduleId;
	private String programId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((scheduleId == null) ? 0 : scheduleId.hashCode());
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
		ApplicantRequest other = (ApplicantRequest) obj;
		if (programId == null) {
			if (other.programId != null)
				return false;
		} else if (!programId.equals(other.programId))
			return false;
		if (scheduleId == null) {
			if (other.scheduleId != null)
				return false;
		} else if (!scheduleId.equals(other.scheduleId))
			return false;
		return true;
	}

	public ApplicantRequest(String scheduleId, String programId) {
		super();
		this.scheduleId = scheduleId;
		this.programId = programId;
	}

	public ApplicantRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	@Override
	public String toString() {
		return "ApplicantRequest [scheduleId=" + scheduleId + ", programId=" + programId + "]";
	}

}
